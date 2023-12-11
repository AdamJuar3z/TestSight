SELECT * FROM northwind.products;
SELECT * FROM suppliers;
SELECT * FROM categories;


#CRUD

#CREATE
INSERT INTO products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
Values('Plutos', 25, 7, '1 peice of fruit', 30, 50, 10, 0, 0);


#UPDATE
UPDATE products
SET UnitsInStock = 100
WHERE ProductID = 78;

UPDATE products
SET UnitsOnOrder = 200, UnitsOnOrder = 50, ReorderLevel = 11
WHERE ProductID = 78;

#DELETE
DELETE
FROM products
WHERE ProductID = 78;


CREATE TABLE pokemon(
PokemonID INT AUTO_INCREMENT,
MoveSet VARCHAR(100),
Type VARCHAR(10),
Name VARCHAR(50),
Hp INT,
Weaknesses VARCHAR(100),
PRIMARY KEY (PokemonID)
);


#ADD
ALTER TABLE pokemon
ADD Location VARCHAR(50) NOT NULL;

#DROP
ALTER TABLE pokemon
DROP COLUMN Location;


