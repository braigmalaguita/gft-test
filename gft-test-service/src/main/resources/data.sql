INSERT INTO BRAND (ID, NAME) VALUES
(1, 'ZARA');
INSERT INTO BRAND (ID, NAME) VALUES
(2, 'LEFTIES');

INSERT INTO PRODUCT (ID, NAME) VALUES
(35455, 'Camiseta roja');
INSERT INTO PRODUCT (ID, NAME) VALUES
(35456, 'Pantalón negro');
INSERT INTO PRODUCT (ID, NAME) VALUES
(35457, 'Falda azul plisada');
INSERT INTO PRODUCT (ID, NAME) VALUES
(35458, 'Zapatillas bailarinas verdes');

INSERT INTO PRICE_LIST (ID, FARE) VALUES
(1, 'normal');
INSERT INTO PRICE_LIST (ID, FARE) VALUES
(2, 'reduced');
INSERT INTO PRICE_LIST (ID, FARE) VALUES
(3, 'discount');
INSERT INTO PRICE_LIST (ID, FARE) VALUES
(4, 'free');

INSERT INTO PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
(1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
(2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
(3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
(4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');
COMMIT;


