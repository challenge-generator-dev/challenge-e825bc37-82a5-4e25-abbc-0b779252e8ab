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