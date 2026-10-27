# Fundamentos de DML en SQL

El dominio es un sistema de gestión de inventarios para una tienda de retail. Los actores clave son el 'gestor de inventarios', el 'sistema de ventas' y el 'motor de reportes'. El gestor de inventarios necesita ejecutar consultas SQL básicas para crear, leer, actualizar y eliminar registros de productos. El sistema de ventas requiere consultas optimizadas para generar informes de ventas por categoría y por fecha. El motor de reportes necesita agrupar y ordenar datos para presentarlos de manera significativa. Las consultas deben ser idempotentes respecto a la clave del producto y manejar errores de consistencia en caso de intentos de eliminación de productos en uso.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Data Manipulation Language (DML) |
| **Nivel** | trainee-l2 |
| **Tipo** | theoretical |
| **Tiempo estimado** | 4 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Consultas CRUD básicas

**Objetivo:** Comprender y ejecutar consultas SQL básicas para crear, leer, actualizar y eliminar registros.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Identificar los campos clave del producto en el inventario.
- Escribir una consulta para insertar un nuevo producto.
- Escribir una consulta para leer todos los productos.
- Escribir una consulta para actualizar el stock de un producto.
- Escribir una consulta para eliminar un producto.

**Entregable:** Documento que describe las consultas CRUD básicas y sus resultados esperados.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que las consultas deben ser idempotentes respecto a la clave del producto.
- Considera los posibles errores de consistencia al eliminar productos.

</details>

### Fase 2: Consultas de optimización

**Objetivo:** Optimizar consultas SQL utilizando Joins, Group By y Order By.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Escribir una consulta que una las tablas de productos y ventas para generar un informe de ventas por categoría.
- Escribir una consulta que agrupe las ventas por fecha y ordene los resultados por volumen de ventas.
- Escribir una consulta que ordene los productos por stock disponible.

**Entregable:** Documento que describe las consultas optimizadas y sus resultados esperados.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza Joins para combinar datos de múltiples tablas.
- Agrupa y ordena los datos para presentarlos de manera significativa.

</details>

### Fase 3: Consultas avanzadas

**Objetivo:** Ejecutar consultas SQL avanzadas para resolver problemas complejos del dominio.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Escribir una consulta que identifique los productos con stock bajo y genere una alerta.
- Escribir una consulta que calcule el total de ventas por categoría y ordene los resultados por volumen de ventas.
- Escribir una consulta que encuentre los productos más vendidos en el último mes.

**Entregable:** Documento que describe las consultas avanzadas y sus resultados esperados.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza funciones agregadas y subconsultas para resolver problemas complejos.
- Asegura que tus consultas sean eficientes y presenten los datos de manera significativa.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son las consultas DML y para qué se utilizan en el dominio de gestión de inventarios?
- **paraQueSirve**: ¿Cómo se aplican las consultas DML para resolver problemas específicos en el dominio de gestión de inventarios?
- **comoSeUsa**: ¿Cómo se escriben y optimizan las consultas DML en el contexto del dominio de gestión de inventarios?
- **erroresComunes**: ¿Cuáles son los errores comunes al escribir consultas DML y cómo se pueden evitar en el dominio de gestión de inventarios?
- **queDecisionesImplica**: ¿Qué decisiones implica la escritura de consultas DML avanzadas en el dominio de gestión de inventarios?

## Criterios de Evaluacion

- Comprensión y ejecución de consultas CRUD básicas.
- Optimización de consultas utilizando Joins, Group By y Order By.
- Escritura de consultas avanzadas para resolver problemas complejos del dominio.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
