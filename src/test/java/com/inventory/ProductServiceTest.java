package com.inventory;


import com.inventory.application.ProductService;
import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductService - Pruebas unitarias de lógica de negocio")
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product testProduct;
    private UUID testProductId;

    @BeforeEach
    void setUp() {
        testProductId = UUID.randomUUID();
        testProduct = new Product(
            "PROD-001",
            "Laptop Dell XPS 15",
            "Laptop de alta gama con procesador Intel i7",
            new BigDecimal("1299.99"),
            50,
            "Electronics"
        );
        testProduct.setId(testProductId);
        testProduct.setCreatedAt(LocalDate.now());
        testProduct.setUpdatedAt(LocalDate.now());
        testProduct.setVersion(0);
    }

    @Nested
    @DisplayName("Creación de productos")
    class CreateProductTests {

        @Test
        @DisplayName("Debe crear producto exitosamente cuando los datos son válidos")
        void shouldCreateProductSuccessfully() {
            when(productRepository.findByCode(testProduct.getCode())).thenReturn(Optional.empty());
            when(productRepository.save(any(Product.class))).thenReturn(testProduct);

            Product result = productService.createProduct(testProduct);

            assertThat(result).isNotNull();
            assertThat(result.getCode()).isEqualTo("PROD-001");
            assertThat(result.getName()).isEqualTo("Laptop Dell XPS 15");
            verify(productRepository, times(1)).save(any(Product.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción cuando el código de producto ya existe")
        void shouldThrowExceptionWhenCodeAlreadyExists() {
            when(productRepository.findByCode(testProduct.getCode())).thenReturn(Optional.of(testProduct));

            assertThatThrownBy(() -> productService.createProduct(testProduct))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("código");
            verify(productRepository, never()).save(any(Product.class));
        }

        @Test
        @DisplayName("Debe validar que el precio sea positivo")
        void shouldValidatePositivePrice() {
            Product invalidProduct = new Product(
                "PROD-002",
                "Producto inválido",
                "Descripción",
                new BigDecimal("-10.00"),
                10,
                "Test"
            );

            assertThatThrownBy(() -> productService.createProduct(invalidProduct))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("precio");
        }

        @Test
        @DisplayName("Debe validar que el stock no sea negativo")
        void shouldValidateNonNegativeStock() {
            Product invalidProduct = new Product(
                "PROD-003",
                "Producto inválido",
                "Descripción",
                new BigDecimal("10.00"),
                -5,
                "Test"
            );

            assertThatThrownBy(() -> productService.createProduct(invalidProduct))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("stock");
        }
    }

    @Nested
    @DisplayName("Actualización de productos")
    class UpdateProductTests {

        @Test
        @DisplayName("Debe actualizar producto exitosamente")
        void shouldUpdateProductSuccessfully() {
            when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
            when(productRepository.save(any(Product.class))).thenReturn(testProduct);

            Product updated = new Product(
                "PROD-001",
                "Laptop Dell XPS 15 Actualizada",
                "Nueva descripción",
                new BigDecimal("1399.99"),
                45,
                "Electronics"
            );
            updated.setId(testProductId);
            updated.setVersion(0);

            Product result = productService.updateProduct(testProductId, updated);

            assertThat(result).isNotNull();
            verify(productRepository, times(1)).save(any(Product.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción al actualizar producto inexistente")
        void shouldThrowExceptionWhenUpdatingNonExistentProduct() {
            UUID nonExistentId = UUID.randomUUID();
            when(productRepository.findById(nonExistentId)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productService.updateProduct(nonExistentId, testProduct))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("no encontrado");
        }
    }

    @Nested
    @DisplayName("Eliminación de productos")
    class DeleteProductTests {

        @Test
        @DisplayName("Debe eliminar producto exitosamente")
        void shouldDeleteProductSuccessfully() {
            when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
            doNothing().when(productRepository).delete(testProduct);

            productService.deleteProduct(testProductId);

            verify(productRepository, times(1)).delete(testProduct);
        }

        @Test
        @DisplayName("Debe lanzar excepción al eliminar producto inexistente")
        void shouldThrowExceptionWhenDeletingNonExistentProduct() {
            UUID nonExistentId = UUID.randomUUID();
            when(productRepository.findById(nonExistentId)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productService.deleteProduct(nonExistentId))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("no encontrado");
        }
    }

    @Nested
    @DisplayName("Consulta de productos")
    class GetProductTests {

        @Test
        @DisplayName("Debe obtener producto por ID exitosamente")
        void shouldGetProductById() {
            when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));

            Optional<Product> result = productService.getProductById(testProductId);

            assertThat(result).isPresent();
            assertThat(result.get().getCode()).isEqualTo("PROD-001");
        }

        @Test
        @DisplayName("Debe retornar vacío cuando el producto no existe")
        void shouldReturnEmptyWhenProductNotFound() {
            UUID nonExistentId = UUID.randomUUID();
            when(productRepository.findById(nonExistentId)).thenReturn(Optional.empty());

            Optional<Product> result = productService.getProductById(nonExistentId);

            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("Debe obtener producto por código")
        void shouldGetProductByCode() {
            when(productRepository.findByCode("PROD-001")).thenReturn(Optional.of(testProduct));

            Optional<Product> result = productService.getProductByCode("PROD-001");

            assertThat(result).isPresent();
            assertThat(result.get().getName()).isEqualTo("Laptop Dell XPS 15");
        }

        @Test
        @DisplayName("Debe buscar productos por nombre")
        void shouldSearchProductsByName() {
            List<Product> products = new ArrayList<>();
            products.add(testProduct);
            when(productRepository.findByNameContainingIgnoreCase("Laptop")).thenReturn(products);

            List<Product> result = productService.searchProductsByName("Laptop");

            assertThat(result).hasSize(1);
            assertThat(result.get(0).getName()).contains("Laptop");
        }

        @Test
        @DisplayName("Debe obtener productos por categoría")
        void shouldGetProductsByCategory() {
            List<Product> products = new ArrayList<>();
            products.add(testProduct);
            when(productRepository.findByCategory("Electronics")).thenReturn(products);

            List<Product> result = productService.getProductsByCategory("Electronics");

            assertThat(result).hasSize(1);
            assertThat(result.get(0).getCategory()).isEqualTo("Electronics");
        }

        @Test
        @DisplayName("Debe obtener productos con stock bajo")
        void shouldGetProductsWithLowStock() {
            Product lowStockProduct = new Product(
                "PROD-002",
                "Producto stock bajo",
                "Descripción",
                new BigDecimal("50.00"),
                5,
                "Test"
            );
            List<Product> products = new ArrayList<>();
            products.add(lowStockProduct);
            when(productRepository.findByStockLessThan(10)).thenReturn(products);

            List<Product> result = productService.getProductsWithLowStock(10);

            assertThat(result).hasSize(1);
            assertThat(result.get(0).getStock()).isLessThan(10);
        }
    }

    @Nested
    @DisplayName("Gestión de stock")
    class StockManagementTests {

        @Test
        @DisplayName("Debe aumentar stock exitosamente")
        void shouldIncreaseStockSuccessfully() {
            when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
            when(productRepository.increaseStock(testProductId, 10)).thenReturn(1);

            boolean result = productService.increaseStock(testProductId, 10);

            assertThat(result).isTrue();
            verify(productRepository, times(1)).increaseStock(testProductId, 10);
        }

        @Test
        @DisplayName("Debe disminuir stock exitosamente")
        void shouldDecreaseStockSuccessfully() {
            when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
            when(productRepository.decreaseStock(testProductId, 5)).thenReturn(1);

            boolean result = productService.decreaseStock(testProductId, 5);

            assertThat(result).isTrue();
            verify(productRepository, times(1)).decreaseStock(testProductId, 5);
        }

        @Test
        @DisplayName("Debe fallar al disminuir stock cuando no hay suficiente")
        void shouldFailToDecreaseStockWhenInsufficient() {
            when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
            when(productRepository.decreaseStock(testProductId, 100)).thenReturn(0);

            assertThatThrownBy(() -> productService.decreaseStock(testProductId, 100))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("stock");
        }
    }

    @Nested
    @DisplayName("Reportes y consultas agregadas")
    class ReportTests {

        @Test
        @DisplayName("Debe obtener stock agrupado por categoría")
        void shouldGetStockByCategory() {
            List<Object[]> stockData = new ArrayList<>();
            stockData.add(new Object[]{"Electronics", 1500});
            stockData.add(new Object[]{"Clothing", 800});
            when(productRepository.getStockByCategory()).thenReturn(stockData);

            List<Object[]> result = productService.getStockByCategoryReport();

            assertThat(result).hasSize(2);
            assertThat(result.get(0)[0]).isEqualTo("Electronics");
        }

        @Test
        @DisplayName("Debe obtener conteo de productos por categoría")
        void shouldGetCountByCategory() {
            List<Object[]> countData = new ArrayList<>();
            countData.add(new Object[]{"Electronics", 50});
            countData.add(new Object[]{"Clothing", 30});
            when(productRepository.countProductsByCategory()).thenReturn(countData);

            List<Object[]> result = productService.getProductCountByCategoryReport();

            assertThat(result).hasSize(2);
            assertThat(result.get(0)[1]).isEqualTo(50);
        }

        @Test
        @DisplayName("Debe buscar productos por rango de precio")
        void shouldFindProductsByPriceRange() {
            List<Product> products = new ArrayList<>();
            products.add(testProduct);
            when(productRepository.findByPriceRange(
                new BigDecimal("1000.00"),
                new BigDecimal("2000.00")
            )).thenReturn(products);

            List<Product> result = productService.findProductsByPriceRange(
                new BigDecimal("1000.00"),
                new BigDecimal("2000.00")
            );

            assertThat(result).hasSize(1);
        }

        @Test
        @DisplayName("Debe buscar productos creados después de una fecha")
        void shouldFindProductsCreatedAfterDate() {
            List<Product> products = new ArrayList<>();
            products.add(testProduct);
            LocalDate testDate = LocalDate.now().minusDays(30);
            when(productRepository.findProductsCreatedAfter(testDate)).thenReturn(products);

            List<Product> result = productService.findRecentProducts(testDate);

            assertThat(result).hasSize(1);
        }
    }
}