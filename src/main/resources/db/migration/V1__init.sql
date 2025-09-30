-- =============================
-- V1__init.sql
-- Initial schema for E-commerce
-- =============================

-- Customers
CREATE TABLE customers (
    customer_id       SERIAL PRIMARY KEY,
    email             VARCHAR(255) UNIQUE NOT NULL,
    password          VARCHAR(255), -- Nullable for OAuth users
    name              VARCHAR(255) NOT NULL,
    auth_provider     VARCHAR(50) NOT NULL DEFAULT 'google',
    provider_user_id  VARCHAR(255), -- Google/GitHub unique ID
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Categories
CREATE TABLE categories (
    category_id   SERIAL PRIMARY KEY,
    name          VARCHAR(100) UNIQUE NOT NULL
);

-- Products
CREATE TABLE products (
    product_id    SERIAL PRIMARY KEY,
    sku           VARCHAR(100) UNIQUE NOT NULL,
    name          VARCHAR(255) NOT NULL,
    description   TEXT,
    price         DECIMAL(10,2) NOT NULL,
    stock         INT NOT NULL CHECK (stock >= 0),
    category_id   INT REFERENCES categories(category_id) ON DELETE SET NULL
);

-- Carts
CREATE TABLE carts (
    cart_id      SERIAL PRIMARY KEY,
    customer_id  INT REFERENCES customers(customer_id) ON DELETE CASCADE,
    product_id   INT REFERENCES products(product_id) ON DELETE CASCADE,
    quantity     INT NOT NULL CHECK (quantity > 0),
    UNIQUE (customer_id, product_id)
);

-- Wishlists
CREATE TABLE wishlists (
    wishlist_id  SERIAL PRIMARY KEY,
    customer_id  INT REFERENCES customers(customer_id) ON DELETE CASCADE,
    product_id   INT REFERENCES products(product_id) ON DELETE CASCADE,
    UNIQUE (customer_id, product_id)
);

-- Orders
CREATE TABLE orders (
    order_id     SERIAL PRIMARY KEY,
    customer_id  INT REFERENCES customers(customer_id) ON DELETE CASCADE,
    order_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_price  DECIMAL(10,2) NOT NULL CHECK (total_price >= 0)
);

-- Order Items
CREATE TABLE order_items (
    order_item_id  SERIAL PRIMARY KEY,
    order_id       INT REFERENCES orders(order_id) ON DELETE CASCADE,
    product_id     INT REFERENCES products(product_id) ON DELETE CASCADE,
    quantity       INT NOT NULL CHECK (quantity > 0),
    price          DECIMAL(10,2) NOT NULL CHECK (price >= 0)
);

-- Payments (linked to orders)
CREATE TABLE payments (
    payment_id     SERIAL PRIMARY KEY,
    order_id       INT UNIQUE REFERENCES orders(order_id) ON DELETE CASCADE,
    payment_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_method VARCHAR(100) NOT NULL,
    amount         DECIMAL(10,2) NOT NULL CHECK (amount >= 0)
);

-- Shipments (linked to orders)
CREATE TABLE shipments (
    shipment_id    SERIAL PRIMARY KEY,
    order_id       INT UNIQUE REFERENCES orders(order_id) ON DELETE CASCADE,
    shipment_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    address        VARCHAR(255) NOT NULL,
    city           VARCHAR(100) NOT NULL,
    state          VARCHAR(50),
    country        VARCHAR(50),
    zip_code       VARCHAR(20)
);
