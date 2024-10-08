CREATE TABLE tblCustomers(
    CustomerID INT PRIMARY KEY,
    CompanyName VARCHAR(60) NOT NULL,
    ContactName VARCHAR(50),
    City VARCHAR(60),
    PostalCode VARCHAR(50),
    Country VARCHAR(100) DEFAULT 'Canada'
);
INSERT INTO tblCustomers (CustomerID, CompanyName, ContactName, City, PostalCode, Country)
VALUES
(1, 'Tech Solutions', 'John','Bangalore' ,'A101','Canada'),
(2, 'Software Innovations', 'Smith', 'Hyderabad','B123', 'Canada');

select*from tblCustomers;
--shippers table
CREATE TABLE tblShippers(
   ShipperID INT PRIMARY KEY,
   CompanyName VARCHAR(100) NOT NULL UNIQUE
);
 
INSERT INTO tblShippers (ShipperID, CompanyName)
VALUES(1, 'FastTrack Shipping'),(2, 'Ocean Freight Ltd.');
 
select*from tblShippers;
 
-- Create tblProducts table
CREATE TABLE tblProducts(
   ProductID INT PRIMARY KEY,
   CategoryID INT,
   ProductName VARCHAR(255),
   EnglishName VARCHAR(255),
   QuantityPerUnit VARCHAR(255),
   UnitPrice DECIMAL(10, 2)
);
INSERT INTO tblProducts (ProductID, CategoryID, ProductName, EnglishName, QuantityPerUnit, UnitPrice)
VALUES
(1, 101, 'Laptop', 'Tech Laptop', '10 units per box', 799.99),
(2, 102, 'Smartphone', 'Tech Phone', '20 units per box', 599.99),
(3, 103, 'Monitor', 'Tech Monitor', '5 units per box', 199.99);
select*from tblProducts;
 


-- Create tblOrders table
CREATE TABLE tblOrders(
   OrderID INT PRIMARY KEY,
   CustomerID INT,
   EmployeeID INT,
   ShipName VARCHAR(255),
   ShipAddress VARCHAR(255),
   ShipCity VARCHAR(100),
   ShipRegion VARCHAR(100),
   ShipPostalCode VARCHAR(50),
   ShipCountry VARCHAR(100),
   ShipVia INT,
   OrderDate DATE,
   RequiredDate DATE,
   ShippedDate DATE CHECK (ShippedDate > OrderDate), 
   Freight DECIMAL(10, 2),
   FOREIGN KEY (CustomerID) REFERENCES tblCustomers(CustomerID),
   FOREIGN KEY (ShipVia) REFERENCES tblShippers(ShipperID)
);
 
 
INSERT INTO tblOrders (OrderID, CustomerID, EmployeeID, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry, ShipVia, OrderDate, RequiredDate, ShippedDate, Freight)
VALUES
(1, 1, 1001, 'John Doe', '123 Tech Lane', 'Vancouver', 'BC', 'V5K 0A1', 'Canada', 1, '2024-10-01', '2024-10-10', '2024-10-05', 50.00),
(2, 2, 1002, 'Jane Smith', '456 Code Road', 'Toronto', 'ON', 'M4B 1B3', 'Canada', 2, '2024-10-02', '2024-10-12', '2024-10-06', 75.00);
 
select*from tblOrders;
 
 
-- Create tblOrderDetails table
CREATE TABLE tblOrderDetails(
   OrderID INT,
   ProductID INT,
   UnitPrice DECIMAL(10, 2),
   Quantity INT CHECK (Quantity > 10), 
   Discount DECIMAL(5, 2),
   PRIMARY KEY (OrderID, ProductID),
   FOREIGN KEY (OrderID) REFERENCES tblOrders(OrderID),
   FOREIGN KEY (ProductID) REFERENCES tblProducts(ProductID)
);
 
INSERT INTO tblOrderDetails (OrderID, ProductID, UnitPrice, Quantity, Discount)
VALUES
(1, 1, 799.99, 15, 0.05),
(1, 2, 599.99, 12, 0.10),
(2, 3, 199.99, 20, 0.00);
 
select*from tblOrderDetails;