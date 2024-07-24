CREATE TABLE BRAND (
    ID INT(11) NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE PRODUCT (
    ID INT(11) NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE PRICE (
    ID INT(11) NOT NULL AUTO_INCREMENT,
    BRAND_ID INT(11) NOT NULL,
    START_DATE TIMESTAMP,
    END_DATE TIMESTAMP,
    PRICE_LIST INT(11),
    PRODUCT_ID INT(11) NOT NULL,
    PRIORITY INT(1),
    PRICE DECIMAL(10,2),
    CURR VARCHAR(255),
    PRIMARY KEY (ID),
    CONSTRAINT FK_brand FOREIGN KEY (BRAND_ID)
        REFERENCES BRAND(ID),
    CONSTRAINT FK_PRODUCT FOREIGN KEY (PRODUCT_ID)
        REFERENCES PRODUCT(ID)
);

INSERT INTO PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES
(1, 1, 2020-06-14-00.00.00, 2020-12-31-23.59.59, 1, 35455, 0, 35.50, 'EUR'),
(2, 1, 2020-06-14-15.00.00, 2020-06-14-18.30.00, 2, 35455, 1, 25.45, 'EUR'),
(3, 1, 2020-06-15-00.00.00, 2020-06-15-11.00.00, 3, 35455, 1, 30.50, 'EUR'),
(4, 1, 2020-06-15-16.00.00, 2020-12-31-23.59.59, 4, 35455, 1, 38.95, 'EUR');

INSERT INTO BRAND (ID, NAME)
VALUES
(1, 'ZARA'),
(2, 'LEFTIES');

INSERT INTO PRODUCT (ID, NAME)
VALUES
(1, 'Camiseta roja'),
(2, 'Pantalón negro'),
(3, 'Falda azul plisada')
(4, 'Zapatillas bailarinas verdes');