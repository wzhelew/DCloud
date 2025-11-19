# DCloud REST API

Примерен Spring Boot REST API (Java 17, Spring Boot 3.2) за работа с MySQL база с пет таблици:

1. **companies** – `id`, `company_name`, `username`, `password`  
2. **suppliers** – `id`, `supplier_name`  
3. **documents** – `id`, `company_id`, `supplier_id`, `document_date`  
4. **items** – `id`, `barcode`, `code`, `name`, `base_id`  
5. **document_items** – `document_id`, `item_code`, `quantity`, `price`

## Конфигурация

Попълнете достъпа до MySQL в `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/dcloud?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=dcloud_user
spring.datasource.password=change_me
spring.jpa.hibernate.ddl-auto=update
```

### Примерна схема

```sql
CREATE TABLE companies (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  company_name VARCHAR(255) NOT NULL,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE suppliers (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  supplier_name VARCHAR(255) NOT NULL
);

CREATE TABLE items (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  barcode VARCHAR(100) NOT NULL,
  code VARCHAR(100) NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL,
  base_id VARCHAR(255)
);

CREATE TABLE documents (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  company_id BIGINT NOT NULL,
  supplier_id BIGINT NOT NULL,
  document_date DATE NOT NULL,
  CONSTRAINT fk_document_company FOREIGN KEY (company_id) REFERENCES companies(id),
  CONSTRAINT fk_document_supplier FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);

CREATE TABLE document_items (
  document_id BIGINT NOT NULL,
  item_code VARCHAR(100) NOT NULL,
  quantity DECIMAL(18,2) NOT NULL,
  price DECIMAL(18,2) NOT NULL,
  PRIMARY KEY (document_id, item_code),
  CONSTRAINT fk_document_items_document FOREIGN KEY (document_id) REFERENCES documents(id),
  CONSTRAINT fk_document_items_item FOREIGN KEY (item_code) REFERENCES items(code)
);
```

### SQL dump за бърз старт

В `sql/dcloud_dump.sql` има готов dump с:

- Създаване на база `dcloud` и всички таблици;
- Примерни данни: фирма с потребител `demo` / `secret`, два доставчика, три артикула и два документа с редовете им.

Импорт:

```bash
mysql -u dcloud_user -p < sql/dcloud_dump.sql
```

## Стартиране

```bash
mvn spring-boot:run
```

Приложението слуша на `http://localhost:8080`.

## REST ендпойнти

| Метод | URL | Описание |
| --- | --- | --- |
| `POST` | `/api/auth/login` | Проверка на потребител и парола. Тяло: `{ "username": "demo", "password": "secret" }`. Връща `valid`, `companyId`, `companyName`. |
| `GET` | `/api/documents?from=2024-05-01&to=2024-05-20` | Всички документи за диапазона по дата (формат `yyyy-MM-dd`). |
| `GET` | `/api/documents/{id}` | Детайли за документ – код, име, баркод, количество и цена за всеки ред. |

