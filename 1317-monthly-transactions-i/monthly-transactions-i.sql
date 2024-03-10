select t1.month, t1.country, t1.trans_count,
case  when t1.country is null then t1.trans_count 
when t2.approved_count is null then 0 else t2.approved_count end as 'approved_count',
t1.trans_total_amount,
case when t1.country is null then t1.trans_total_amount 
when t2.approved_total_amount is null then 0 else t2.approved_total_amount end as 'approved_total_amount' from 
(select DATE_FORMAT(trans_date, '%Y-%m') as month, country, 
count(state) as trans_count, sum(amount) as trans_total_amount
from transactions
group by month, country) t1 
left join 
(select DATE_FORMAT(trans_date, '%Y-%m') as month, country, 
count(state) as approved_count, sum(amount) as approved_total_amount
from transactions
where state = 'approved'
group by month, country) t2
on t1.month = t2.month and t1.country = t2.country;
