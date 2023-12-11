SELECT *
FROM customers
WHERE Country = 'Germany' AND City = 'Berlin';

SELECT *
FROM customers
WHERE Country = 'Germany' OR City = 'Sweden';

SELECT *
FROM orders
WHERE Freight > 50;

SELECT * 
FROM orders
WHERE ShipCountry IN ('Brazil', 'Belgium', 'Austria'); 

SELECT ContactName, CompanyName, Address
From customers
ORDER BY ContactName DESC;
# DESC tells it to order it from z-a where as in removing DESC will get the order from a-z

/*
This allows from multiple lines to be
commented out
*/

#What country do our customers come from
SELECT DISTINCT(Country)
FROM customers
ORDER BY Country;

SELECT *
From customers
Where CompanyName LIKE 'H%';

SELECT *
FROM customers
WHERE CompanyName LIKE '%es';


SELECT * 
FROM customer 
WHERE CompanyName LIKE '%Sea%';


SELECT * 
FROM orders
WHERE ShipRegion IS NULL;