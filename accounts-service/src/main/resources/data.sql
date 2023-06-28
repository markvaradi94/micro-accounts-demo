DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS accounts;

CREATE TABLE customers
(
    `customer_id`   int AUTO_INCREMENT PRIMARY KEY,
    `name`          varchar(100) NOT NULL,
    `email`         varchar(100) NOT NULL,
    `mobile_number` varchar(20)  NOT NULL,
    `created_date`  date DEFAULT NULL
);

CREATE TABLE accounts
(
    `customer_id`    int          NOT NULL,
    `account_number` int AUTO_INCREMENT PRIMARY KEY,
    `account_type`   varchar(100) NOT NULL,
    `branch_address` varchar(200) NOT NULL,
    `created_date`   date DEFAULT NULL
);

INSERT INTO customers (name, email, mobile_number, created_date)
VALUES ('Olidam', 'oli@dam.com', '111222333', CURDATE());

INSERT INTO accounts (customer_id, account_number, account_type, branch_address, created_date)
VALUES (1, 42069, 'Savings', '123 Bors Street, Oradea', CURDATE());
