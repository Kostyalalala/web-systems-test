CREATE DATABASE equation_db;
ALTER DATABASE equation_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'mypass!32';
GRANT ALL PRIVILEGES ON equation_db.* TO 'user'@'localhost';

CREATE TABLE equations
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    a Double,
    b Double,
    c Double,
    determinant Double,
    firstRoot Double,
    secondRoot Double
)
