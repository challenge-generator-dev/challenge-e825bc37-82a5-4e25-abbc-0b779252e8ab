package com.inventory.application;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import com.inventory.application.exception.ProductNotFoundException;
import com.inventory.application.exception.DuplicateProductCodeException;
import com.inventory.application.exception.InsufficientStockException;
import com.inventory.application.exception.ProductInUseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(String code, String name, String description, 
                                  BigDecimal price, Integer stock, String category) {
        Optional<Product> existingProduct = productRepository.findByCode(code);
        if (existingProduct.isPresent()) {
            throw new DuplicateProductCodeException("Ya existe un producto con el código: " + code);
        }

        Product product = new Product(code, name, description, price, stock, category);
        return productRepository.save(product);
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado con ID: " + id));
    }

    public Product getProductByCode(String code) {
        return productRepository.findByCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado con código: " + code));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getLowStockProducts(Integer threshold) {
        return productRepository.findByStockLessThan(threshold);
    }

    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceRange(minPrice, maxPrice);
    }

    public List<Product> getProductsCreatedAfter(LocalDate date) {
        return productRepository.findProductsCreatedAfter(date);
    }

    @Transactional
    public Product updateProduct(UUID id, String name, String description, 
                                  BigDecimal price, Integer stock, String category) {
        Product product = getProductById(id);
        
        if (name != null && !name.isBlank()) {
            product.setName(name);
        }
        if (description != null) {
            product.setDescription(description);
        }
        if (price != null) {
            product.setPrice(price);
        }
        if (stock != null) {
            product.setStock(stock);
        }
        if (category != null && !category.isBlank()) {
            product.setCategory(category);
        }
        
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(UUID id) {
        Product product = getProductById(id);
        
        if (product.getStock() > 0) {
            throw new ProductInUseException("No se puede eliminar un producto con stock disponible");
        }
        
        productRepository.delete(product);
    }

    @Transactional
    public Product decreaseStock(UUID id, Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad a decrementar debe ser mayor que cero");
        }
        
        Product product = getProductById(id);
        
        if (product.getStock() < quantity) {
            throw new InsufficientStockException(
                "Stock insuficiente. Stock actual: " + product.getStock() + 
                ", cantidad solicitada: " + quantity);
        }
        
        int rowsAffected = productRepository.decreaseStock(id, quantity);
        if (rowsAffected == 0) {
            throw new RuntimeException("Error al decrementar stock");
        }
        
        return getProductById(id);
    }

    @Transactional
    public Product increaseStock(UUID id, Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad a incrementar debe ser mayor que cero");
        }
        
        Product product = getProductById(id);
        int rowsAffected = productRepository.increaseStock(id, quantity);
        if (rowsAffected == 0) {
            throw new RuntimeException("Error al incrementar stock");
        }
        
        return getProductById(id);
    }

    public List<Object[]> getStockSummaryByCategory() {
        return productRepository.getStockByCategory();
    }

    public List<Object[]> getProductCountByCategory() {
        return productRepository.countProductsByCategory();
    }
}