-- DCloud schema and seed data
--
-- Import with: mysql -u dcloud_user -p < sql/dcloud_dump.sql

DROP DATABASE IF EXISTS dcloud;
CREATE DATABASE dcloud CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE dcloud;

CREATE TABLE companies (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  company_name VARCHAR(255) NOT NULL,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE suppliers (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  supplier_name VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE items (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  barcode VARCHAR(100) NOT NULL,
  code VARCHAR(100) NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL,
  base_id VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE documents (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  company_id BIGINT NOT NULL,
  supplier_id BIGINT NOT NULL,
  document_date DATE NOT NULL,
  CONSTRAINT fk_document_company FOREIGN KEY (company_id) REFERENCES companies(id),
  CONSTRAINT fk_document_supplier FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
) ENGINE=InnoDB;

CREATE TABLE document_items (
  document_id BIGINT NOT NULL,
  item_code VARCHAR(100) NOT NULL,
  quantity DECIMAL(18,2) NOT NULL,
  price DECIMAL(18,2) NOT NULL,
  PRIMARY KEY (document_id, item_code),
  CONSTRAINT fk_document_items_document FOREIGN KEY (document_id) REFERENCES documents(id),
  CONSTRAINT fk_document_items_item FOREIGN KEY (item_code) REFERENCES items(code)
) ENGINE=InnoDB;

-- Seed data
INSERT INTO companies (company_name, username, password) VALUES
('Demo Firm', 'demo', 'secret');

INSERT INTO suppliers (supplier_name) VALUES
('Техно Снаб'),
('Офис Плюс');

INSERT INTO items (barcode, code, name, base_id) VALUES
('3800000000010', 'ART-001', 'Лаптоп Pro 14', 'B001'),
('3800000000027', 'ART-002', 'Мишка Безжична', 'B002'),
('3800000000034', 'ART-003', 'Клавиатура Механична', 'B003');

INSERT INTO documents (company_id, supplier_id, document_date) VALUES
(1, 1, '2024-05-10'),
(1, 2, '2024-05-18');

INSERT INTO document_items (document_id, item_code, quantity, price) VALUES
(1, 'ART-001', 5, 1899.00),
(1, 'ART-002', 10, 49.90),
(2, 'ART-002', 6, 47.50),
(2, 'ART-003', 4, 129.00);
