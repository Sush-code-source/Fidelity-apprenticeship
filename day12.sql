CREATE TABLE Customer (
customer_id VARCHAR(10)
PRIMARY KEY,
customer_name VARCHAR(20),
address VARCHAR(20),
phone_no BIGINT,
email_id VARCHAR(20)
);

CREATE TABLE delivery_partners (
partner_id VARCHAR(10)
PRIMARY KEY,
partner_name VARCHAR(20),
phone_no BIGINT,
rating INT
);

CREATE TABLE hotel_details (
hotel_id VARCHAR(10)
PRIMARY KEY,
hotel_name VARCHAR(20),
hotel_type VARCHAR(20),
rating INT
);

CREATE TABLE orders (
order_id VARCHAR(10)
PRIMARY KEY,
customer_id VARCHAR(10),
hotel_id VARCHAR(10),
partner_id VARCHAR(10),
order_date DATE,
FOREIGN KEY (customer_id)
REFERENCES
customer(customer_id),
FOREIGN KEY (hotel_id)
REFERENCES
hotel_details(hotel_id),
FOREIGN KEY (partner_id)
REFERENCES
delivery_partners(partner_id)
);

INSERT INTO customer (customer_id, customer_name, address, phone_no, email_id)
VALUES ('C001', 'Sush', '123 Main St', '8867070231', 'sush@gmail.com'),
       ('C002', 'Abhi', '456 Main St', '7829465546', 'abi@gmail.com');
select*from Customer

INSERT INTO delivery_partners (partner_id, partner_name, phone_no, rating )
VALUES ('POO1', 'Mike Delivery', '9876543212', 5),
       ('P002', 'Sarah Express', '9876543213', 4);
select*from delivery_partners

INSERT INTO hotel_details (hotel_id, hotel_name, hotel_type, rating)
VALUES ('H001', 'Grand Hotel', 'Luxury', 5),
       ('H002','Budget Inn', 'Budget', 3);
select*from hotel_details

INSERT INTO ORDERS (order_id, customer_id, hotel_id, partner_id, order_date)
VALUES ('0001', 'C001', 'H001', 'POO1', '2024-10-09'),
       ('0002', 'C002', 'H002', 'P002', '2024-10-10');
select*from ORDERS

--Delivery Partner details based on rating
SELECT partner_id, partner_name, phone_no
FROM delivery_partners
WHERE rating BETWEEN 3 AND 5
ORDER BY partner_id;

-- Hunger eats - update table
UPDATE customer
SET phone_no=9876543210
WHERE customer_id='CUST1004';

--Customers having gmail id
SELECT customer_id,
customer_name, address, phone_no
FROM customer
WHERE email_id LIKE '%@gmail.com'
ORDER BY customer_id;

--Hunger eats - change datatype
ALTER table orders drop constraint orders_customer_id_fkey;
UPDATE customer set customer_id = regexp_replace(customer_id, '[^0-9]', '', 'g');
ALTER table customer alter column customer_id type int using customer_id :: integer;

--Hunger eats - Change the field name
ALTER TABLE Hotel_details RENAME
COLUMN rating TO Hotel_rating;

--Hotel_info
SELECT CONCAT(hotel_name, 'is a', hotel_type, 'hotel')
AS HOTEL_INFO
FROM Hotel_details
ORDER BY hotel_name DESC;

--Hotels that took order more than five times
SELECT hd.hotel_id, hd.hotel_name,
COUNT(o.order_id) AS NO_OF_ORDERS
FROM Hotel_details hd
JOIN orders o ON  hd.hotel_id=o.hotel_id
GROUP BY hd.hotel_id, hd.hotel_name
HAVING COUNT(o.order_id)>5
ORDER BY hd.hotel_id ASC;

--Hotels not taken orders in a specific month1Q
SELECT hd.hotel_id, hd.hotel_name, hd.hotel_type
FROM Hotel_details hd
LEFT JOIN orders o ON hd.hotel_id=o.hotel_id
AND o.order_date >='2019-05-01'
AND o.order_date<'2019-06-01'
WHERE O.order_id IS NULL
ORDER BY hd.hotel_id ASC;

--Order details
SELECT column_name,data_type
FROM information_schema.columns
WHERE table_name='orders';
SELECT column_name,data_type
FROM information_schema.columns
WHERE table_name='Customer';
SELECT column_name, data_type
FROM information_schema.columns
WHERE table_schema='public'
AND table_name='orders';
SELECT column_name,data_type
FROM information_schema.columns
WHERE table_schema='public'
AND table_name='Customer';

--Pizza Store - Update PIZZA table 1
create table customer(cust_id varchar(10), cust_name varchar(20), cust_phone bigint, cust_address varchar(20));
alter table customer add constraint cust_pkey primary key(cust_id);
create table delivery_partner(partner_id varchar(10) primary key, partner_name varchar(15), rating bigint);
create table pizza(pizza_id varchar(10), cust_id varchar(10) references customer(cust_id), partner_id varchar(10) references delivery_partner(partner_id), 
pizza_name varchar(15), pizza_type varchar(15), order_date date, amount bigint);
insert into customer values (1, 'john', 555-1234),(2, 'jane', 5891234),(3, 'smith', 5551234);
insert into delivery_partner values('p001', 'zomato', 8),('p002', 'blink', 6),('p003', 'swiggy', 10);
insert into pizza values('a001', 1, 'p001','margherita', 'large', '2024-06-09', 500),
('a002', 2, 'p002','Pepperoni', 'small', '2023-08-09', 800),('a003', 3, 'p003', 'onion','large', '2024-08-09', 900);
update pizza set amount = amount * 0.97 where pizza_type = 'large';
