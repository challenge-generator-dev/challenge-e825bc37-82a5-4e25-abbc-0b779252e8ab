# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/inventory/application/ProductService.java` — `com.inventory.application.exception.ProductNotFoundException`: El import com.inventory.application.exception.ProductNotFoundException usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/application/ProductService.java` — `com.inventory.application.exception.DuplicateProductCodeException`: El import com.inventory.application.exception.DuplicateProductCodeException usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/application/ProductService.java` — `com.inventory.application.exception.InsufficientStockException`: El import com.inventory.application.exception.InsufficientStockException usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/application/ProductService.java` — `com.inventory.application.exception.ProductInUseException`: El import com.inventory.application.exception.ProductInUseException usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.CreateProductRequest`: El import com.inventory.infrastructure.dto.CreateProductRequest usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.UpdateProductRequest`: El import com.inventory.infrastructure.dto.UpdateProductRequest usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.ProductResponse`: El import com.inventory.infrastructure.dto.ProductResponse usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.StockAdjustmentRequest`: El import com.inventory.infrastructure.dto.StockAdjustmentRequest usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.CategorySummaryResponse`: El import com.inventory.infrastructure.dto.CategorySummaryResponse usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/inventory/application/ProductService.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inventory/application/ProductService.java` — `ProductRepository.delete`: Se invoca `delete` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductServiceTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductServiceTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductServiceTest.java` — `Product.get`: Se invoca `get` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.getProductsWithLowStock`: Se invoca `getProductsWithLowStock` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.getStockByCategoryReport`: Se invoca `getStockByCategoryReport` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.getProductCountByCategoryReport`: Se invoca `getProductCountByCategoryReport` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.findProductsByPriceRange`: Se invoca `findProductsByPriceRange` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.findRecentProducts`: Se invoca `findRecentProducts` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductRepositoryTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inventory/ProductRepositoryTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología SQL, Trainee L2

### Brecha de conocimiento
Ejecuta consultas SQL basicas CRUD y de optimizacion como Joins, Group By y Order By., Ejecuta consultas SQL basicas CRUD y de optimizacion.

### Reto
- Tema: Data Manipulation Language (DML)
- Seniority: trainee-l2
- Tipo: theoretical
- Título: Fundamentos de DML en SQL
- Tiempo estimado: 4 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Consultas CRUD básicas — objetivo: Comprender y ejecutar consultas SQL básicas para crear, leer, actualizar y eliminar registros. — entregable (NO resolver): Documento que describe las consultas CRUD básicas y sus resultados esperados.
- Fase 2: Consultas de optimización — objetivo: Optimizar consultas SQL utilizando Joins, Group By y Order By. — entregable (NO resolver): Documento que describe las consultas optimizadas y sus resultados esperados.
- Fase 3: Consultas avanzadas — objetivo: Ejecutar consultas SQL avanzadas para resolver problemas complejos del dominio. — entregable (NO resolver): Documento que describe las consultas avanzadas y sus resultados esperados.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/inventorydb
    username: inventoryuser
    password: inventorypass
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000

  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: validate
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        jdbc:
          time_zone: UTC

  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true
    validate-on-migrate: true

server:
  port: 8080
  error:
    include-message: always
    include-binding-errors: always

logging:
  level:
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.springframework.web: INFO
    com.inventory: DEBUG

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.inventory</groupId>
    <artifactId>inventory-management</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>inventory-management</name>
    <description>Sistema de gestión de inventarios para retail</description>

    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
            <version>42.7.3</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Flyway -->
        <dependency>
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-core</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <argLine>--add-opens java.base/java.lang=ALL-UNNAMED</argLine>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

// === ARCHIVO: src/main/java/com/inventory/Application.java ===
package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}

// === ARCHIVO: src/main/java/com/inventory/domain/Product.java ===
package com.inventory.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "El código del producto no puede estar vacío")
    @Size(max = 50, message = "El código del producto no puede exceder 50 caracteres")
    private String code;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 100, message = "El nombre del producto no puede exceder 100 caracteres")
    private String name;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 255, message = "La descripción no puede exceder 255 caracteres")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser positivo")
    private BigDecimal price;

    @Column(nullable = false)
    @NotNull(message = "La cantidad en stock no puede ser nula")
    @PositiveOrZero(message = "La cantidad en stock no puede ser negativa")
    private Integer stock;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "La categoría no puede estar vacía")
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    private String category;

    @Column(name = "created_at", nullable = false, updatable = false)
    @NotNull(message = "La fecha de creación no puede ser nula")
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    @NotNull(message = "La fecha de actualización no puede ser nula")
    private LocalDate updatedAt;

    @Version
    private Integer version;

    public Product() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Product(String code, String name, String description, BigDecimal price, Integer stock, String category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}

// === ARCHIVO: src/main/java/com/inventory/domain/ProductRepository.java ===
package com.inventory.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByCode(String code);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(String category);

    List<Product> findByStockLessThan(Integer stock);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

    @Query("SELECT p FROM Product p WHERE p.createdAt >= :date")
    List<Product> findProductsCreatedAfter(@Param("date") LocalDate date);

    @Modifying
    @Query("UPDATE Product p SET p.stock = p.stock - :quantity WHERE p.id = :id")
    int decreaseStock(@Param("id") UUID id, @Param("quantity") Integer quantity);

    @Modifying
    @Query("UPDATE Product p SET p.stock = p.stock + :quantity WHERE p.id = :id")
    int increaseStock(@Param("id") UUID id, @Param("quantity") Integer quantity);

    @Query("SELECT p.category, SUM(p.stock) FROM Product p GROUP BY p.category")
    List<Object[]> getStockByCategory();

    @Query("SELECT p.category, COUNT(p) FROM Product p GROUP BY p.category")
    List<Object[]> countProductsByCategory();
}

// === ARCHIVO: src/main/java/com/inventory/application/ProductService.java ===
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

// === ARCHIVO: src/main/java/com/inventory/infrastructure/ProductRepositoryImpl.java ===
package com.inventory.infrastructure;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
            product.setCreatedAt(LocalDate.now());
            product.setVersion(0);
            entityManager.persist(product);
        } else {
            product.preUpdate();
            product.setVersion(product.getVersion() + 1);
            product = entityManager.merge(product);
        }
        return product;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        Product product = entityManager.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Product p ORDER BY p.name", Product.class);
        return query.getResultList();
    }

    @Override
    public void delete(Product product) {
        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
    }

    @Override
    public Optional<Product> findByCode(String code) {
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.code = :code", Product.class);
        query.setParameter("code", code);
        List<Product> results = query.getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY p.name",
            Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Product> findByCategory(String category) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.category = :category ORDER BY p.name",
            Product.class);
        query.setParameter("category", category);
        return query.getResultList();
    }

    @Override
    public List<Product> findByStockLessThan(Integer stock) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.stock < :stock ORDER BY p.stock ASC",
            Product.class);
        query.setParameter("stock", stock);
        return query.getResultList();
    }

    @Override
    public List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price DESC",
            Product.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        return query.getResultList();
    }

    @Override
    public List<Product> findProductsCreatedAfter(LocalDate date) {
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.createdAt > :date ORDER BY p.createdAt DESC",
            Product.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public int decreaseStock(UUID id, Integer quantity) {
        Query query = entityManager.createQuery(
            "UPDATE Product p SET p.stock = p.stock - :quantity, p.version = p.version + 1 " +
            "WHERE p.id = :id AND p.stock >= :quantity");
        query.setParameter("id", id);
        query.setParameter("quantity", quantity);
        return query.executeUpdate();
    }

    @Override
    public int increaseStock(UUID id, Integer quantity) {
        Query query = entityManager.createQuery(
            "UPDATE Product p SET p.stock = p.stock + :quantity, p.version = p.version + 1 " +
            "WHERE p.id = :id");
        query.setParameter("id", id);
        query.setParameter("quantity", quantity);
        return query.executeUpdate();
    }

    @Override
    public List<Object[]> getStockByCategory() {
        Query query = entityManager.createQuery(
            "SELECT p.category, SUM(p.stock) FROM Product p GROUP BY p.category ORDER BY SUM(p.stock) DESC");
        return query.getResultList();
    }

    @Override
    public List<Object[]> countProductsByCategory() {
        Query query = entityManager.createQuery(
            "SELECT p.category, COUNT(p) FROM Product p GROUP BY p.category ORDER BY COUNT(p) DESC");
        return query.getResultList();
    }
}

// === ARCHIVO: src/main/java/com/inventory/infrastructure/ProductController.java ===
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

// === ARCHIVO: src/main/resources/schema.sql ===
-- Schema para el sistema de gestión de inventarios
-- Compatible con PostgreSQL 16 y Spring Data JPA

-- Tabla principal de productos
CREATE TABLE IF NOT EXISTS products (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0),
    category VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version INTEGER NOT NULL DEFAULT 0
);

-- Tabla de ventas
CREATE TABLE IF NOT EXISTS sales (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_id UUID NOT NULL REFERENCES products(id) ON DELETE RESTRICT,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    unit_price DECIMAL(10, 2) NOT NULL CHECK (unit_price >= 0),
    total_price DECIMAL(10, 2) NOT NULL CHECK (total_price >= 0),
    sale_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    customer_name VARCHAR(200),
    status VARCHAR(20) NOT NULL DEFAULT 'COMPLETED' CHECK (status IN ('PENDING', 'COMPLETED', 'CANCELLED'))
);

-- Tabla de categorías para inventario
CREATE TABLE IF NOT EXISTS categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Índice para búsquedas por código de producto (único)
CREATE UNIQUE INDEX idx_products_code ON products(code);

-- Índice para búsquedas por nombre (búsqueda parcial)
CREATE INDEX idx_products_name ON products USING gin(to_tsvector('spanish', name));

-- Índice para búsquedas por categoría
CREATE INDEX idx_products_category ON products(category);

-- Índice para búsquedas por stock bajo
CREATE INDEX idx_products_stock ON products(stock) WHERE stock < 10;

-- Índice para búsquedas por rango de precios
CREATE INDEX idx_products_price ON products(price);

-- Índice para búsquedas por fecha de creación
CREATE INDEX idx_products_created_at ON products(created_at);

-- Índice para búsquedas por ID de producto en ventas
CREATE INDEX idx_sales_product_id ON sales(product_id);

-- Índice para búsquedas por fecha de venta
CREATE INDEX idx_sales_date ON sales(sale_date);

-- Índice para búsquedas por estado de venta
CREATE INDEX idx_sales_status ON sales(status);

-- Índice compuesto para reportes de ventas por producto y fecha
CREATE INDEX idx_sales_product_date ON sales(product_id, sale_date);

-- Función para actualizar automáticamente updated_at
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para actualizar timestamp en products
DROP TRIGGER IF EXISTS update_products_updated_at ON products;
CREATE TRIGGER update_products_updated_at
    BEFORE UPDATE ON products
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

-- Función para validar código de producto
CREATE OR REPLACE FUNCTION validate_product_code()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.code IS NULL OR TRIM(NEW.code) = '' THEN
        RAISE EXCEPTION 'El código del producto no puede estar vacío';
    END IF;
    IF LENGTH(NEW.code) < 3 THEN
        RAISE EXCEPTION 'El código del producto debe tener al menos 3 caracteres';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para validación de código
DROP TRIGGER IF EXISTS validate_product_code_trigger ON products;
CREATE TRIGGER validate_product_code_trigger
    BEFORE INSERT OR UPDATE ON products
    FOR EACH ROW
    EXECUTE FUNCTION validate_product_code();

-- Función para calcular total de venta automáticamente
CREATE OR REPLACE FUNCTION calculate_total_price()
RETURNS TRIGGER AS $$
BEGIN
    NEW.total_price = NEW.quantity * NEW.unit_price;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para cálculo automático del total
DROP TRIGGER IF EXISTS calculate_total_price_trigger ON sales;
CREATE TRIGGER calculate_total_price_trigger
    BEFORE INSERT OR UPDATE ON sales
    FOR EACH ROW
    EXECUTE FUNCTION calculate_total_price();

-- Vista para reporte de inventario por categoría
CREATE OR REPLACE VIEW inventory_by_category AS
SELECT 
    category,
    COUNT(*) AS total_products,
    SUM(stock) AS total_stock,
    AVG(price) AS average_price,
    MIN(price) AS min_price,
    MAX(price) AS max_price,
    SUM(stock * price) AS total_inventory_value
FROM products
GROUP BY category;

-- Vista para reporte de ventas por producto
CREATE OR REPLACE VIEW sales_by_product AS
SELECT 
    p.id AS product_id,
    p.code AS product_code,
    p.name AS product_name,
    p.category,
    COUNT(s.id) AS total_sales,
    SUM(s.quantity) AS total_quantity_sold,
    SUM(s.total_price) AS total_revenue,
    AVG(s.unit_price) AS average_sale_price
FROM products p
LEFT JOIN sales s ON p.id = s.product_id
WHERE s.status = 'COMPLETED'
GROUP BY p.id, p.code, p.name, p.category;

-- Vista para productos con bajo stock
CREATE OR REPLACE VIEW low_stock_products AS
SELECT 
    id,
    code,
    name,
    category,
    stock,
    price,
    created_at
FROM products
WHERE stock < 10
ORDER BY stock ASC, name ASC;

// === ARCHIVO: src/main/resources/data.sql ===
-- Datos de ejemplo para el sistema de gestión de inventarios
-- Compatible con PostgreSQL 16

-- Insertar categorías
INSERT INTO categories (id, name, description) VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Electrónica', 'Dispositivos electrónicos y accesorios'),
    ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Ropa', 'Prendas de vestir y accesorios'),
    ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Alimentos', 'Productos alimenticios y bebidas'),
    ('d0eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'Hogar', 'Muebles y artículos del hogar'),
    ('e0eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'Deportes', 'Equipos y accesorios deportivos')
ON CONFLICT (name) DO NOTHING;

-- Insertar productos de Electrónica
INSERT INTO products (id, code, name, description, price, stock, category, created_at, updated_at, version) VALUES
    ('11111111-1111-1111-1111-111111111111', 'ELEC001', 'Laptop HP Pavilion', 'Laptop 15.6 pulgadas, 8GB RAM, 256GB SSD', 899.99, 15, 'Electrónica', '2024-01-15 10:00:00', '2024-01-15 10:00:00', 0),
    ('22222222-2222-2222-2222-222222222222', 'ELEC002', 'Mouse Inalámbrico', 'Mouse ergonómico inalámbrico USB', 29.99, 50, 'Electrónica', '2024-01-16 11:30:00', '2024-01-16 11:30:00', 0),
    ('33333333-3333-3333-3333-333333333333', 'ELEC003', 'Teclado Mecánico', 'Teclado gaming RGB switches rojos', 79.99, 8, 'Electrónica', '2024-01-17 09:15:00', '2024-01-17 09:15:00', 0),
    ('44444444-4444-4444-4444-444444444444', 'ELEC004', 'Monitor 24 pulgadas', 'Monitor Full HD 75Hz', 189.99, 12, 'Electrónica', '2024-01-18 14:20:00', '2024-01-18 14:20:00', 0),
    ('55555555-5555-5555-5555-555555555555', 'ELEC005', 'Auriculares Bluetooth', 'Auriculares over-ear con cancelación de ruido', 149.99, 5, 'Electrónica', '2024-01-19 16:45:00', '2024-01-19 16:45:00', 0)
ON CONFLICT (code) DO NOTHING;

-- Insertar productos de Ropa
INSERT INTO products (id, code, name, description, price, stock, category, created_at, updated_at, version) VALUES
    ('66666666-6666-6666-6666-666666666666', 'ROPA001', 'Camiseta Algodón', 'Camiseta 100% algodón, varios colores', 19.99, 100, 'Ropa', '2024-01-20 08:00:00', '2024-01-20 08:00:00', 0),
    ('77777777-7777-7777-7777-777777777777', 'ROPA002', 'Jeans Slim', 'Pantalón jeans corte slim', 49.99, 45, 'Ropa', '2024-01-21 09:30:00', '2024-01-21 09:30:00', 0),
    ('88888888-8888-8888-8888-888888888888', 'ROPA003', 'Chaqueta Invierno', 'Chaqueta acolchada para invierno', 89.99, 20, 'Ropa', '2024-01-22 11:00:00', '2024-01-22 11:00:00', 0),
    ('99999999-9999-9999-9999-999999999999', 'ROPA004', 'Zapatillas Running', 'Zapatillas para correr profesional', 119.99, 30, 'Ropa', '2024-01-23 13:15:00', '2024-01-23 13:15:00', 0)
ON CONFLICT (code) DO NOTHING;

-- Insertar productos de Alimentos
INSERT INTO products (id, code, name, description, price, stock, category, created_at, updated_at, version) VALUES
    ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'ALIM001', 'Café Premium 1kg', 'Café en grano premium importado', 24.99, 60, 'Alimentos', '2024-01-24 07:00:00', '2024-01-24 07:00:00', 0),
    ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'ALIM002', 'Aceite de Oliva 1L', 'Aceite de oliva extra virgen', 12.99, 80, 'Alimentos', '2024-01-25 08:30:00', '2024-01-25 08:30:00', 0),
    ('cccccccc-cccc-cccc-cccc-cccccccccccc', 'ALIM003', 'Pasta Italiana 500g', 'Pasta italiana متنوعة varieties', 3.99, 200, 'Alimentos', '2024-01-26 10:00:00', '2024-01-26 10:00:00', 0),
    ('dddddddd-dddd-dddd-dddd-dddddddddddd', 'ALIM004', 'Chocolate Artesanal', 'Chocolate artesanal 70% cacao', 8.99, 40, 'Alimentos', '2024-01-27 12:00:00', '2024-01-27 12:00:00', 0)
ON CONFLICT (code) DO NOTHING;

-- Insertar productos de Hogar
INSERT INTO products (id, code, name, description, price, stock, category, created_at, updated_at, version) VALUES
    ('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', 'HOGAR001', 'Juego de Sábanas', 'Juego de sábanas cotton 200 hilos', 34.99, 25, 'Hogar', '2024-01-28 09:00:00', '2024-01-28 09:00:00', 0),
    ('ffffffff-ffff-ffff-ffff-ffffffffffff', 'HOGAR002', 'Lámpara de Mesa', 'Lámpara LED regulable con touch', 44.99, 18, 'Hogar', '2024-01-29 11:30:00', '2024-01-29 11:30:00', 0),
    ('11111111-2222-3333-4444-555555555555', 'HOGAR003', 'Set de Ollas', 'Set de 5 ollas de acero inoxidable', 79.99, 15, 'Hogar', '2024-01-30 14:00:00', '2024-01-30 14:00:00', 0)
ON CONFLICT (code) DO NOTHING;

-- Insertar productos de Deportes
INSERT INTO products (id, code, name, description, price, stock, category, created_at, updated_at, version) VALUES
    ('22222222-3333-4444-5555-666666666666', 'DEPTO001', 'Balón de Fútbol', 'Balón de fútbol profesional', 24.99, 35, 'Deportes', '2024-01-31 08:00:00', '2024-01-31 08:00:00', 0),
    ('33333333-4444-5555-6666-777777777777', 'DEPTO002', 'Raqueta Tenis', 'Raqueta de tenis graphite', 89.99, 12, 'Deportes', '2024-02-01 10:30:00', '2024-02-01 10:30:00', 0),
    ('44444444-5555-6666-7777-888888888888', 'DEPTO003', 'Mancuernas 10kg', 'Par de mancuernas de 10kg', 59.99, 8, 'Deportes', '2024-02-02 13:00:00', '2024-02-02 13:00:00', 0)
ON CONFLICT (code) DO NOTHING;

-- Insertar ventas de ejemplo
-- Ventas de Electrónica
INSERT INTO sales (id, product_id, quantity, unit_price, total_price, sale_date, customer_name, status) VALUES
    ('aaaa1111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111', 2, 899.99, 1799.98, '2024-02-01 10:30:00', 'Juan Pérez', 'COMPLETED'),
    ('aaaa2222-2222-2222-2222-222222222222', '22222222-2222-2222-2222-222222222222', 5, 29.99, 149.95, '2024-02-01 11:00:00', 'María García', 'COMPLETED'),
    ('aaaa3333-3333-3333-3333-333333333333', '33333333-3333-3333-3333-333333333333', 1, 79.99, 79.99, '2024-02-02 09:15:00', 'Carlos López', 'COMPLETED'),
    ('aaaa4444-4444-4444-4444-444444444444', '44444444-4444-4444-4444-444444444444', 3, 189.99, 569.97, '2024-02-02 14:30:00', 'Ana Martínez', 'COMPLETED'),
    ('aaaa5555-5555-5555-5555-555555555555', '55555555-5555-5555-5555-555555555555', 2, 149.99, 299.98, '2024-02-03 16:00:00', 'Pedro Sánchez', 'COMPLETED'),
    ('aaaa6666-6666-6666-6666-666666666666', '11111111-1111-1111-1111-111111111111', 1, 899.99, 899.99, '2024-02-03 17:30:00', 'Laura Rodríguez', 'COMPLETED')
ON CONFLICT DO NOTHING;

-- Ventas de Ropa
INSERT INTO sales (id, product_id, quantity, unit_price, total_price, sale_date, customer_name, status) VALUES
    ('bbbb1111-1111-1111-1111-111111111111', '66666666-6666-6666-6666-666666666666', 10, 19.99, 199.90, '2024-02-01 12:00:00', 'Miguel Torres', 'COMPLETED'),
    ('bbbb2222-2222-2222-2222-222222222222', '77777777-7777-7777-7777-777777777777', 3, 49.99, 149.97, '2024-02-01 15:30:00', 'Sofia Hernández', 'COMPLETED'),
    ('bbbb3333-3333-3333-3333-333333333333', '88888888-8888-8888-8888-888888888888', 1, 89.99, 89.99, '2024-02-02 10:00:00', 'Diego Rivera', 'COMPLETED'),
    ('bbbb4444-4444-4444-4444-444444444444', '99999999-9999-9999-9999-999999999999', 2, 119.99, 239.98, '2024-02-03 11:30:00', 'Isabel Flores', 'COMPLETED'),
    ('bbbb5555-5555-5555-5555-555555555555', '66666666-6666-6666-6666-666666666666', 5, 19.99, 99.95, '2024-02-04 09:00:00', 'Roberto Díaz', 'PENDING')
ON CONFLICT DO NOTHING;

-- Ventas de Alimentos
INSERT INTO sales (id, product_id, quantity, unit_price, total_price, sale_date, customer_name, status) VALUES
    ('cccc1111-1111-1111-1111-111111111111', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 4, 24.99, 99.96, '2024-02-01 08:30:00', 'Patricia Morales', 'COMPLETED'),
    ('cccc2222-2222-2222-2222-222222222222', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 6, 12.99, 77.94, '2024-02-01 14:00:00', 'Jorge Castro', 'COMPLETED'),
    ('cccc3333-3333-3333-3333-333333333333', 'cccccccc-cccc-cccc-cccc-cccccccccccc', 12, 3.99, 47.88, '2024-02-02 10:30:00', 'Carmen Ruiz', 'COMPLETED'),
    ('cccc4444-4444-4444-4444-444444444444', 'dddddddd-dddd-dddd-dddd-dddddddddddd', 8, 8.99, 71.92, '2024-02-03 12:00:00', 'Alberto Romero', 'COMPLETED'),
    ('cccc5555-5555-5555-5555-555555555555', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 2, 24.99, 49.98, '2024-02-04 15:30:00', 'Elena Vargas', 'CANCELLED')
ON CONFLICT DO NOTHING;

-- Ventas de Hogar
INSERT INTO sales (id, product_id, quantity, unit_price, total_price, sale_date, customer_name, status) VALUES
    ('dddd1111-1111-1111-1111-111111111111', 'eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', 2, 34.99, 69.98, '2024-02-02 11:00:00', 'Fernando Herrera', 'COMPLETED'),
    ('dddd2222-2222-2222-2222-222222222222', 'ffffffff-ffff-ffff-ffff-ffffffffffff', 1, 44.99, 44.99, '2024-02-03 13:30:00', 'Gloria Jiménez', 'COMPLETED'),
    ('dddd3333-3333-3333-3333-333333333333', '11111111-2222-3333-4444-555555555555', 1, 79.99, 79.99, '2024-02-04 10:00:00', 'Ricardo Peña', 'COMPLETED')
ON CONFLICT DO NOTHING;

-- Ventas de Deportes
INSERT INTO sales (id, product_id, quantity, unit_price, total_price, sale_date, customer_name, status) VALUES
    ('eeee1111-1111-1111-1111-111111111111', '22222222-3333-4444-5555-666666666666', 3, 24.99, 74.97, '2024-02-01 16:00:00', 'Andrea Soto', 'COMPLETED'),
    ('eeee2222-2222-2222-2222-222222222222', '33333333-4444-5555-6666-777777777777', 1, 89.99, 89.99, '2024-02-02 17:30:00', 'Marcelo Vega', 'COMPLETED'),
    ('eeee3333-3333-3333-3333-333333333333', '44444444-5555-6666-7777-888888888888', 2, 59.99, 119.98, '2024-02-03 18:00:00', 'Claudia Aguirre', 'COMPLETED'),
    ('eeee4444-4444-4444-4444-444444444444', '22222222-3333-4444-5555-666666666666', 1, 24.99, 24.99, '2024-02-04 19:00:00', 'Sergio Mendoza', 'PENDING')
ON CONFLICT DO NOTHING;

-- Actualizar el stock de productos después de ventas
-- Electrónica
UPDATE products SET stock = stock - 2 WHERE code = 'ELEC001';
UPDATE products SET stock = stock - 5 WHERE code = 'ELEC002';
UPDATE products SET stock = stock - 1 WHERE code = 'ELEC003';
UPDATE products SET stock = stock - 3 WHERE code = 'ELEC004';
UPDATE products SET stock = stock - 2 WHERE code = 'ELEC005';

-- Ropa
UPDATE products SET stock = stock - 10 WHERE code = 'ROPA001';
UPDATE products SET stock = stock - 3 WHERE code = 'ROPA002';
UPDATE products SET stock = stock - 1 WHERE code = 'ROPA003';
UPDATE products SET stock = stock - 2 WHERE code = 'ROPA004';

-- Alimentos
UPDATE products SET stock = stock - 4 WHERE code = 'ALIM001';
UPDATE products SET stock = stock - 6 WHERE code = 'ALIM002';
UPDATE products SET stock = stock - 12 WHERE code = 'ALIM003';
UPDATE products SET stock = stock - 8 WHERE code = 'ALIM004';

-- Hogar
UPDATE products SET stock = stock - 2 WHERE code = 'HOGAR001';
UPDATE products SET stock = stock - 1 WHERE code = 'HOGAR002';
UPDATE products SET stock = stock - 1 WHERE code = 'HOGAR003';

-- Deportes
UPDATE products SET stock = stock - 3 WHERE code = 'DEPTO001';
UPDATE products SET stock = stock - 1 WHERE code = 'DEPTO002';
UPDATE products SET stock = stock - 2 WHERE code = 'DEPTO003';

// === ARCHIVO: src/test/java/com/inventory/ProductServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/inventory/ProductRepositoryTest.java ===
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
```
