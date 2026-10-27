package com.inventory.infrastructure;

import com.inventory.application.ProductService;
import com.inventory.domain.Product;
import com.inventory.infrastructure.dto.CreateProductRequest;
import com.inventory.infrastructure.dto.UpdateProductRequest;
import com.inventory.infrastructure.dto.ProductResponse;
import com.inventory.infrastructure.dto.StockAdjustmentRequest;
import com.inventory.infrastructure.dto.CategorySummaryResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        Product product = productService.createProduct(
            request.code(),
            request.name(),
            request.description(),
            request.price(),
            request.stock(),
            request.category()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse.fromEntity(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(ProductResponse.fromEntity(product));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ProductResponse> getProductByCode(@PathVariable String code) {
        Product product = productService.getProductByCode(code);
        return ResponseEntity.ok(ProductResponse.fromEntity(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponse> responses = products.stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProductsByName(@RequestParam String name) {
        List<Product> products = productService.searchProductsByName(name);
        List<ProductResponse> responses = products.stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        List<ProductResponse> responses = products.stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductResponse>> getLowStockProducts(@RequestParam(defaultValue = "10") Integer threshold) {
        List<Product> products = productService.getLowStockProducts(threshold);
        List<ProductResponse> responses = products.stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<ProductResponse>> getProductsByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        List<ProductResponse> responses = products.stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/created-after")
    public ResponseEntity<List<ProductResponse>> getProductsCreatedAfter(@RequestParam LocalDate date) {
        List<Product> products = productService.getProductsCreatedAfter(date);
        List<ProductResponse> responses = products.stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateProductRequest request) {
        Product product = productService.updateProduct(
            id,
            request.name(),
            request.description(),
            request.price(),
            request.stock(),
            request.category()
        );
        return ResponseEntity.ok(ProductResponse.fromEntity(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/decrease-stock")
    public ResponseEntity<ProductResponse> decreaseStock(
            @PathVariable UUID id,
            @Valid @RequestBody StockAdjustmentRequest request) {
        Product product = productService.decreaseStock(id, request.quantity());
        return ResponseEntity.ok(ProductResponse.fromEntity(product));
    }

    @PostMapping("/{id}/increase-stock")
    public ResponseEntity<ProductResponse> increaseStock(
            @PathVariable UUID id,
            @Valid @RequestBody StockAdjustmentRequest request) {
        Product product = productService.increaseStock(id, request.quantity());
        return ResponseEntity.ok(ProductResponse.fromEntity(product));
    }

    @GetMapping("/reports/stock-by-category")
    public ResponseEntity<List<CategorySummaryResponse>> getStockByCategory() {
        List<Object[]> results = productService.getStockSummaryByCategory();
        List<CategorySummaryResponse> responses = results.stream()
            .map(r -> new CategorySummaryResponse((String) r[0], ((Number) r[1]).longValue()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/reports/count-by-category")
    public ResponseEntity<List<CategorySummaryResponse>> getCountByCategory() {
        List<Object[]> results = productService.getProductCountByCategory();
        List<CategorySummaryResponse> responses = results.stream()
            .map(r -> new CategorySummaryResponse((String) r[0], ((Number) r[1]).longValue()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}