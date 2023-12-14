CREATE DATABASE DealershipDatabase;

CREATE TABLE Dealership(
dealership_id INT PRIMARY KEY auto_increment,
NAME VARCHAR(50),
address VARCHAR(50),
phone VARCHAR(12)
);

CREATE TABLE Vehicle(
VIN VARCHAR(50) PRIMARY KEY,
vehicle_type VARCHAR(50),
odometer INT,
year_made INT,
make VARCHAR(100),
model VARCHAR(100),
color VARCHAR(50),
price FLOAT,
sold BIT,
ActualCashValue INT
);

CREATE TABLE Inventory(
dealership_id INT,
VIN VARCHAR(50),
FOREIGN KEY (dealership_id) REFERENCES Dealership(dealership_id),
FOREIGN KEY (VIN) REFERENCES Vehicle(VIN)
);


CREATE TABLE sales_contract(
id INT,
VIN VARCHAR(50),
FOREIGN KEY (VIN) REFERENCES Vehicle(VIN)
);


INSERT INTO Dealership (NAME, address, phone) VALUES
('1-800 Motores', '123 Main St', '123-456-7890'),
('Dis FO Autos', '456 Oak Ave', '987-654-3210'),
('UsedCars 4 Cheap', '789 Elm Blvd', '456-789-0123');

INSERT INTO Vehicle (VIN, vehicle_type, odometer, year_made, make, model, color, price, sold, ActualCashValue) VALUES
('1RTA234DEF5678901', 'Sedan', 15000, 2022, 'Toyota', 'Camry', 'Blue', 25000.00, 1, 22000),
('2PLA345GHI6789012', 'SUV', 20000, 2021, 'Honda', 'CR-V', 'Red', 30000.00, 0, 28000),
('3FLA456GHI7890123', 'Truck', 18000, 2020, 'Ford', 'F-150', 'Black', 35000.00, 1, 32000);

INSERT INTO Inventory(dealership_id, VIN) VALUES
(1, '1RTA234DEF5678901'),
(2, '2PLA345GHI6789012'),
(3, '3FLA456GHI7890123');


INSERT INTO sales_contract (id, VIN) VALUES
(1, '1RTA234DEF5678901'),
(2, '2PLA345GHI6789012'),
(3, '3FLA456GHI7890123');







