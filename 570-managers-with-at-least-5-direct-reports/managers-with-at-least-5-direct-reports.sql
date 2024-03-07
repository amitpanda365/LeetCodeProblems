# Write your MySQL query statement below
select t1.name from employee t1 inner join
(select e.id as id, count(1) from 
employee e inner join employee m
on e.id = m.managerId 
group by e.id having count(1) >= 5) t2
on t1.id = t2.id;