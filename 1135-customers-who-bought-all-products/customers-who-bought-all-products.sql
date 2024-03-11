# Write your MySQL query statement below
select customer_id from 
(select customer_id,
count(distinct product_key) as cnt
from customer
group by customer_id) t
where cnt = (select count(product_key) from product);