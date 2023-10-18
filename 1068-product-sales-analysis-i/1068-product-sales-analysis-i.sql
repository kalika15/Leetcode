# Write your MySQL query statement below
# select Product.product_name, Sales.year, Sales.price from Sales, Product where Sales.product_id=Product.product_id;

Select product_name, year, price from sales inner join Product on Sales.product_id= Product.product_id;