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