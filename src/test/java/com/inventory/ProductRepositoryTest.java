package com.inventory;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.hibernate.ddl-auto=none",
    "spring.flyway.enabled=false"
})
@DisplayName("ProductRepository - Pruebas de integración de consultas SQL")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Product testProduct1;
    private Product testProduct2;
    private Product testProduct3;

    @BeforeEach
    void setUp() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "products");

        testProduct1 = new Product(
            "ELEC-001",
            "Laptop Dell XPS",
            "Laptop de alta gama",
            new BigDecimal("1299.99"),
            100,
            "Electronics"
        );
        testProduct1.setId(UUID.randomUUID());
        testProduct1.setCreatedAt(LocalDate.now().minusDays(10));
        testProduct1.setUpdatedAt(LocalDate.now().minusDays(10));
        testProduct1.setVersion(0);

        testProduct2 = new Product(
            "ELEC-002",
            "Mouse Logitech",
            "Mouse inalámbrico",
            new BigDecimal("29.99"),
            200,
            "Electronics"
        );
        testProduct2.setId(UUID.randomUUID());
        testProduct2.setCreatedAt(LocalDate.now().minusDays(5));
        testProduct2.setUpdatedAt(LocalDate.now().minusDays(5));
        testProduct2.setVersion(0);

        testProduct3 = new Product(
            "CLOTH-001",
            "Camisa Manga Larga",
            "Camisa de algodón",
            new BigDecimal("49.99"),
            50,
            "Clothing"
        );
        testProduct3.setId(UUID.randomUUID());
        testProduct3.setCreatedAt(LocalDate.now().minusDays(2));
        testProduct3.setUpdatedAt(LocalDate.now().minusDays(2));
        testProduct3.setVersion(0);

        productRepository.save(testProduct1);
        productRepository.save(testProduct2);
        productRepository.save(testProduct3);
    }

    @Nested
    @DisplayName("Consultas básicas de lectura")
    class BasicReadQueriesTests {

        @Test
        @DisplayName("findByCode debe retornar producto cuando existe")
        void shouldFindByCodeWhenExists() {
            Optional<Product> result = productRepository.findByCode("ELEC-001");

            assertThat(result).isPresent();
            assertThat(result.get().getName()).isEqualTo("Laptop Dell XPS");
        }

        @Test
        @DisplayName("findByCode debe retornar vacío cuando no existe")
        void shouldReturnEmptyWhenCodeNotExists() {
            Optional<Product> result = productRepository.findByCode("NON-EXIST");

            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("findByNameContainingIgnoreCase debe buscar sin importar mayúsculas")
        void shouldSearchByNameCaseInsensitive() {
            List<Product> result = productRepository.findByNameContainingIgnoreCase("LAPTOP");

            assertThat(result).hasSize(1);
            assertThat(result.get(0).getName()).isEqualTo("Laptop Dell XPS");
        }

        @Test
        @DisplayName("findByNameContainingIgnoreCase debe retornar lista vacía cuando no hay coincidencias")
        void shouldReturnEmptyListWhenNoMatch() {
            List<Product> result = productRepository.findByNameContainingIgnoreCase("XYZ123");

            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("findByCategory debe filtrar por categoría correctamente")
        void shouldFilterByCategory() {
            List<Product> result = productRepository.findByCategory("Electronics");

            assertThat(result).hasSize(2);
            assertThat(result).allMatch(p -> p.getCategory().equals("Electronics"));
        }

        @Test
        @DisplayName("findByStockLessThan debe encontrar productos con bajo stock")
        void shouldFindLowStockProducts() {
            Product lowStockProduct = new Product(
                "LOW-001",
                "Producto stock bajo",
                "Descripción",
                new BigDecimal("10.00"),
                5,
                "Test"
            );
            lowStockProduct.setId(UUID.randomUUID());
            lowStockProduct.setCreatedAt(LocalDate.now());
            lowStockProduct.setUpdatedAt(LocalDate.now());
            lowStockProduct.setVersion(0);
            productRepository.save(lowStockProduct);

            List<Product> result = productRepository.findByStockLessThan(10);

            assertThat(result).hasSize(1);
            assertThat(result.get(0).getCode()).isEqualTo("LOW-001");
        }
    }

    @Nested
    @DisplayName("Consultas con parámetros")
    class ParameterizedQueriesTests {

        @Test
        @DisplayName("findByPriceRange debe filtrar productos entre precios")
        void shouldFilterByPriceRange() {
            List<Product> result = productRepository.findByPriceRange(
                new BigDecimal("20.00"),
                new BigDecimal("100.00")
            );

            assertThat(result).hasSize(1);
            assertThat(result.get(0).getCode()).isEqualTo("CLOTH-001");
        }

        @Test
        @DisplayName("findByPriceRange debe incluir precios límite")
        void shouldIncludeBoundaryPrices() {
            List<Product> result = productRepository.findByPriceRange(
                new BigDecimal("29.99"),
                new BigDecimal("49.99")
            );

            assertThat(result).hasSize(2);
        }

        @Test
        @DisplayName("findProductsCreatedAfter debe filtrar por fecha de creación")
        void shouldFilterByCreatedDate() {
            LocalDate filterDate = LocalDate.now().minusDays(7);
            List<Product> result = productRepository.findProductsCreatedAfter(filterDate);

            assertThat(result).hasSize(2);
            assertThat(result).allMatch(p -> p.getCreatedAt().isAfter(filterDate));
        }

        @Test
        @DisplayName("findProductsCreatedAfter debe retornar vacío para fecha futura")
        void shouldReturnEmptyForFutureDate() {
            LocalDate futureDate = LocalDate.now().plusDays(30);
            List<Product> result = productRepository.findProductsCreatedAfter(futureDate);

            assertThat(result).isEmpty();
        }
    }

    @Nested
    @DisplayName("Consultas de modificación de stock")
    class StockModificationQueriesTests {

        @Test
        @DisplayName("decreaseStock debe reducir el stock correctamente")
        void shouldDecreaseStock() {
            int initialStock = testProduct1.getStock();
            int quantityToDecrease = 10;

            int result = productRepository.decreaseStock(testProduct1.getId(), quantityToDecrease);

            assertThat(result).isEqualTo(1);
            Optional<Product> updated = productRepository.findById(testProduct1.getId());
            assertThat(updated.get().getStock()).isEqualTo(initialStock - quantityToDecrease);
        }

        @Test
        @DisplayName("decreaseStock debe fallar si stock es insuficiente")
        void shouldFailDecreaseWhenInsufficientStock() {
            Product limitedProduct = new Product(
                "LIMIT-001",
                "Stock limitado",
                "Descripción",
                new BigDecimal("10.00"),
                5,
                "Test"
            );
            limitedProduct.setId(UUID.randomUUID());
            limitedProduct.setCreatedAt(LocalDate.now());
            limitedProduct.setUpdatedAt(LocalDate.now());
            limitedProduct.setVersion(0);
            productRepository.save(limitedProduct);

            int result = productRepository.decreaseStock(limitedProduct.getId(), 100);

            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("increaseStock debe aumentar el stock correctamente")
        void shouldIncreaseStock() {
            int initialStock = testProduct1.getStock();
            int quantityToIncrease = 50;

            int result = productRepository.increaseStock(testProduct1.getId(), quantityToIncrease);

            assertThat(result).isEqualTo(1);
            Optional<Product> updated = productRepository.findById(testProduct1.getId());
            assertThat(updated.get().getStock()).isEqualTo(initialStock + quantityToIncrease);
        }

        @Test
        @DisplayName("increaseStock debe retornar 0 para producto inexistente")
        void shouldReturnZeroForNonExistentProduct() {
            UUID nonExistentId = UUID.randomUUID();
            int result = productRepository.increaseStock(nonExistentId, 10);

            assertThat(result).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("Consultas agregadas y de agrupamiento")
    class AggregationQueriesTests {

        @Test
        @DisplayName("getStockByCategory debe agrupar y sumar stock por categoría")
        void shouldGroupAndSumStockByCategory() {
            List<Object[]> result = productRepository.getStockByCategory();

            assertThat(result).hasSize(2);
            boolean hasElectronics = result.stream().anyMatch(row -> "Electronics".equals(row[0]));
            boolean hasClothing = result.stream().anyMatch(row -> "Clothing".equals(row[0]));
            assertThat(hasElectronics).isTrue();
            assertThat(hasClothing).isTrue();
        }

        @Test
        @DisplayName("getStockByCategory debe sumar correctamente el stock total")
        void shouldCalculateCorrectTotalStock() {
            List<Object[]> result = productRepository.getStockByCategory();

            Object[] electronicsRow = result.stream()
                .filter(row -> "Electronics".equals(row[0]))
                .findFirst()
                .orElse(null);

            assertThat(electronicsRow).isNotNull();
            assertThat(electronicsRow[1]).isEqualTo(300L);
        }

        @Test
        @DisplayName("countProductsByCategory debe contar productos por categoría")
        void shouldCountProductsByCategory() {
            List<Object[]> result = productRepository.countProductsByCategory();

            assertThat(result).hasSize(2);
            Object[] electronicsRow = result.stream()
                .filter(row -> "Electronics".equals(row[0]))
                .findFirst()
                .orElse(null);

            assertThat(electronicsRow).isNotNull();
            assertThat(electronicsRow[1]).isEqualTo(2L);
        }

        @Test
        @DisplayName("countProductsByCategory debe incluir todas las categorías")
        void shouldIncludeAllCategories() {
            List<Object[]> result = productRepository.countProductsByCategory();

            assertThat(result.stream().map(row -> (String) row[0]))
                .containsExactlyInAnyOrder("Electronics", "Clothing");
        }
    }

    @Nested
    @DisplayName("Idempotencia y consistencia")
    class IdempotencyTests {

        @Test
        @DisplayName("Múltiples consultas con el mismo código deben ser idempotentes")
        void shouldBeIdempotentForSameCode() {
            Optional<Product> firstCall = productRepository.findByCode("ELEC-001");
            Optional<Product> secondCall = productRepository.findByCode("ELEC-001");
            Optional<Product> thirdCall = productRepository.findByCode("ELEC-001");

            assertThat(firstCall).isPresent();
            assertThat(secondCall).isPresent();
            assertThat(thirdCall).isPresent();
            assertThat(firstCall.get().getId()).isEqualTo(secondCall.get().getId());
            assertThat(secondCall.get().getId()).isEqualTo(thirdCall.get().getId());
        }

        @Test
        @DisplayName("La disminución de stock debe ser idempotente respecto al ID")
        void shouldBeIdempotentForStockDecrease() {
            UUID productId = testProduct1.getId();

            int firstResult = productRepository.decreaseStock(productId, 5);
            int secondResult = productRepository.decreaseStock(productId, 5);

            assertThat(firstResult).isEqualTo(1);
            assertThat(secondResult).isEqualTo(1);
        }

        @Test
        @DisplayName("Las consultas agregadas deben ser consistentes")
        void shouldBeConsistentForAggregationQueries() {
            List<Object[]> stockResult = productRepository.getStockByCategory();
            List<Object[]> countResult = productRepository.countProductsByCategory();

            assertThat(stockResult).hasSize(countResult.size());
        }
    }

    @Nested
    @DisplayName("Casos de borde")
    class EdgeCaseTests {

        @Test
        @DisplayName("Debe manejar consulta con precio mínimo mayor al máximo")
        void shouldHandleInvalidPriceRange() {
            List<Product> result = productRepository.findByPriceRange(
                new BigDecimal("200.00"),
                new BigDecimal("50.00")
            );

            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("Debe manejar categoría sin productos")
        void shouldHandleCategoryWithNoProducts() {
            List<Product> result = productRepository.findByCategory("NonExistent");

            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("Debe manejar búsqueda de nombre vacío")
        void shouldHandleEmptyNameSearch() {
            List<Product> result = productRepository.findByNameContainingIgnoreCase("");

            assertThat(result).hasSize(3);
        }

        @Test
        @DisplayName("No debe fallar con stock negativo en consulta")
        void shouldHandleNegativeStockThreshold() {
            assertThatCode(() -> productRepository.findByStockLessThan(-1))
                .doesNotThrowAnyException();
        }
    }
}