# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Fundamentos de DML en SQL**.

| | |
|---|---|
| Tema | Data Manipulation Language (DML) |
| Nivel | trainee-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | SQL / Spring Data JPA |
| Patron arquitectonico | capas estándar |
| Tiempo estimado | 4 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-data-jpa 3.5.6
- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.postgresql:postgresql 42.7.3
- org.springframework.boot:spring-boot-starter-test n/a
- org.projectlombok:lombok 1.18.34

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Consultas CRUD básicas**: Documento que describe las consultas CRUD básicas y sus resultados esperados.
- **Fase 2 — Consultas de optimización**: Documento que describe las consultas optimizadas y sus resultados esperados.
- **Fase 3 — Consultas avanzadas**: Documento que describe las consultas avanzadas y sus resultados esperados.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (23)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/inventory/application/ProductService.java` — `com.inventory.application.exception.ProductNotFoundException`
      El import com.inventory.application.exception.ProductNotFoundException usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `com.inventory.application.exception.DuplicateProductCodeException`
      El import com.inventory.application.exception.DuplicateProductCodeException usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `com.inventory.application.exception.InsufficientStockException`
      El import com.inventory.application.exception.InsufficientStockException usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `com.inventory.application.exception.ProductInUseException`
      El import com.inventory.application.exception.ProductInUseException usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.CreateProductRequest`
      El import com.inventory.infrastructure.dto.CreateProductRequest usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.UpdateProductRequest`
      El import com.inventory.infrastructure.dto.UpdateProductRequest usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.ProductResponse`
      El import com.inventory.infrastructure.dto.ProductResponse usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.StockAdjustmentRequest`
      El import com.inventory.infrastructure.dto.StockAdjustmentRequest usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/infrastructure/ProductController.java` — `com.inventory.infrastructure.dto.CategorySummaryResponse`
      El import com.inventory.infrastructure.dto.CategorySummaryResponse usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `ProductRepository.findAll`
      Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inventory/application/ProductService.java` — `ProductRepository.delete`
      Se invoca `delete` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductServiceTest.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductServiceTest.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductServiceTest.java` — `Product.get`
      Se invoca `get` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.getProductsWithLowStock`
      Se invoca `getProductsWithLowStock` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.getStockByCategoryReport`
      Se invoca `getStockByCategoryReport` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.getProductCountByCategoryReport`
      Se invoca `getProductCountByCategoryReport` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.findProductsByPriceRange`
      Se invoca `findProductsByPriceRange` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductServiceTest.java` — `ProductService.findRecentProducts`
      Se invoca `findRecentProducts` sobre `ProductService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductRepositoryTest.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inventory/ProductRepositoryTest.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (12)

- `src/main/resources/application.yml`
- `pom.xml`
- `src/main/java/com/inventory/Application.java`
- `src/main/java/com/inventory/domain/Product.java`
- `src/main/java/com/inventory/domain/ProductRepository.java`
- `src/main/java/com/inventory/application/ProductService.java`
- `src/main/java/com/inventory/infrastructure/ProductRepositoryImpl.java`
- `src/main/java/com/inventory/infrastructure/ProductController.java`
- `src/main/resources/schema.sql`
- `src/main/resources/data.sql`
- `src/test/java/com/inventory/ProductServiceTest.java`
- `src/test/java/com/inventory/ProductRepositoryTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/inventory/domain`
- `src/main/java/com/inventory/application`
- `src/main/java/com/inventory/infrastructure`
- `src/main/resources`
- `src/test/java/com/inventory`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología SQL, Trainee L2
- Brecha que el reto ataca: Ejecuta consultas SQL basicas CRUD y de optimizacion como Joins, Group By y Order By., Ejecuta consultas SQL basicas CRUD y de optimizacion.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
