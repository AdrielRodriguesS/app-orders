INSERT INTO CLIENT (company_name, cnpj, email, phone, client_since) VALUES('Client one', '01.001.001/0001-01', 'clientone@emial.com', '(11)1111-1111', '2022-01-01');
INSERT INTO CLIENT (company_name, cnpj, email, phone, client_since) VALUES('Client two', '02.002.002/0001-02', 'clienttwo@emial.com', '(22)2222-2222', '2022-02-02');
INSERT INTO CLIENT (company_name, cnpj, email, phone, client_since) VALUES('Client three', '03.003.003/0001-03', 'clientthree@emial.com', '(33)3333-3333', '2022-03-03');
INSERT INTO CLIENT (company_name, cnpj, email, phone, client_since) VALUES('Client four', '04.004.004/0001-04', 'clientfour@emial.com', '(44)4444-4444', '2022-04-04');
INSERT INTO CLIENT (company_name, cnpj, email, phone, client_since) VALUES('Client five', '05.005.005/0001-05', 'clientfive@emial.com', '(55)5555-5555', '2022-05-05');

INSERT INTO ADRESS (adress, number, city, state, country, zip_code, client_id) VALUES ('Street One-one', '01', 'CityOne', 'StateOne', 'CountryOne', '11111-110', '1');
INSERT INTO ADRESS (adress, number, city, state, country, zip_code, client_id) VALUES ('Street One-two', '11', 'CityOne', 'StateOne', 'CountryOne', '11111-111', '1');
INSERT INTO ADRESS (adress, number, city, state, country, zip_code, client_id) VALUES ('Street Two-one', '02', 'CityTwo', 'StateTwo', 'CountryTwo', '22222-220', '2');
INSERT INTO ADRESS (adress, number, city, state, country, zip_code, client_id) VALUES ('Street Three-one', '03', 'CityThree', 'StateThree', 'CountryThree', '33333-330', '3');
INSERT INTO ADRESS (adress, number, city, state, country, zip_code, client_id) VALUES ('Street Three-two', '33', 'CityThree', 'StateThree', 'CountryThree', '33333-331', '3');
INSERT INTO ADRESS (adress, number, city, state, country, zip_code, client_id) VALUES ('Street Four-one', '04', 'CityFour', 'StateFour', 'CountryFour', '44444-440', '4');
INSERT INTO ADRESS (adress, number, city, state, country, zip_code, client_id) VALUES ('Street Five-one', '05', 'CityFive', 'StateFive', 'CountryFive', '55555-550', '5');

INSERT INTO STORAGE(inventory_date) VALUES ('2022-01-01');

INSERT INTO PRODUCT (description, reference, price, manufacturer, purchase_unit, storage_id) VALUES ('productOne', 'PR-001', '100', 'IndustryOne', 'UN', '1');
INSERT INTO PRODUCT (description, reference, price, manufacturer, purchase_unit, storage_id) VALUES ('productTwo', 'PR-002', '200', 'IndustryTwo', 'PC', '1');
INSERT INTO PRODUCT (description, reference, price, manufacturer, purchase_unit, storage_id) VALUES ('productThree', 'PR-003', '300', 'IndustryThree', 'CX', '1');
INSERT INTO PRODUCT (description, reference, price, manufacturer, purchase_unit, storage_id) VALUES ('productFour', 'PR-004', '400', 'IndustryFour', 'MT', '1');
INSERT INTO PRODUCT (description, reference, price, manufacturer, purchase_unit, storage_id) VALUES ('productFive', 'PR-005', '500', 'IndustryFive', 'UN', '1');

INSERT INTO STORAGE_DATA(location, quantity, product_id) VALUES ('A-01', '10', '1');
INSERT INTO STORAGE_DATA(location, quantity, product_id) VALUES ('B-02', '20', '2');
INSERT INTO STORAGE_DATA(location, quantity, product_id) VALUES ('C-03', '30', '3');
INSERT INTO STORAGE_DATA(location, quantity, product_id) VALUES ('D-04', '40', '4');
INSERT INTO STORAGE_DATA(location, quantity, product_id) VALUES ('E-05', '50', '5');

INSERT INTO QUOTATION(quotation_date, final_price, quotation_status, client_id) VALUES('2022-01-01', '10000', 'LOST', '1');
INSERT INTO QUOTATION(quotation_date, final_price, quotation_status, client_id) VALUES('2022-02-02', '20000', 'WIN', '2');
INSERT INTO QUOTATION(quotation_date, final_price, quotation_status, client_id) VALUES('2022-03-03', '30000', 'LOST', '3');

INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('1', '100', '1', '1');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('2', '200', '2', '2');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('3', '300', '3', '3');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('4', '400', '4', '1');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('5', '500', '5', '2');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('6', '600', '1', '3');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('7', '700', '2', '1');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('8', '800', '3', '2');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('9', '900', '4', '3');
INSERT INTO QUOTATION_PRODUCT(quantity, total_price, product_id, quotation_id) VALUES('10', '1000', '5', '1');


INSERT INTO PURCHASE_ORDER(purchase_order_date, final_price, order_status) VALUES('2022-01-01', '10000', 'DELIVERED');
INSERT INTO PURCHASE_ORDER(purchase_order_date, final_price, order_status) VALUES('2022-02-02', '20000', 'NOT_DELIVERED');
INSERT INTO PURCHASE_ORDER(purchase_order_date, final_price, order_status) VALUES('2022-03-03', '30000', 'DELIVERED');




