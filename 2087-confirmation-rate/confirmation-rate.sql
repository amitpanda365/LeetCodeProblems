# Write your MySQL query statement below

select s.user_id, 
case 
when t3.confirmation_rate is null then 0 
else t3.confirmation_rate
end as confirmation_rate
from signups s
left join
(select t1.user_id, round((t1.ca/t2.ct), 2) as confirmation_rate from
(select user_id, count(action) as ca from confirmations
where action = "confirmed"
group by user_id) t1
inner join
(select user_id, count(action) as ct from confirmations
group by user_id) t2 on t1.user_id = t2.user_id) t3
on s.user_id=t3.user_id;