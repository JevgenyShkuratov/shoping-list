CREATE TABLE `shopping_carts` (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40)
);

CREATE TABLE products
(

    id          BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(40) NOT NULL,
    description VARCHAR(255),
    price       DECIMAL(19, 2),
    discount    DECIMAL(19, 2),
    category    VARCHAR(255),
    shopping_Cart_id BIGINT,

        UNIQUE (name),
        FOREIGN KEY (shopping_Cart_id) REFERENCES products(id)

);

