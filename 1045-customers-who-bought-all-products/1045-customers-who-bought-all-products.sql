# Write your MySQL query statement below
select customer_id from customer group by (customer_id) having count(DISTINCT product_key)= (select count(DISTINCT product_key) from customer);