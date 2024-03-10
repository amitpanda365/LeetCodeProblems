SELECT t1.mnt as month,
       t1.country,
       t1.trans_count,
       CASE
           WHEN t1.country IS NULL THEN t1.trans_count
           WHEN t2.approved_count IS NULL THEN 0
           ELSE t2.approved_count
       END AS approved_count,
       t1.trans_total_amount,
       CASE
           WHEN t1.country IS NULL THEN t1.trans_total_amount
           WHEN t2.approved_total_amount IS NULL THEN 0
           ELSE t2.approved_total_amount
       END AS approved_total_amount
FROM
    (SELECT TO_CHAR(trans_date, 'yyyy-MM') AS mnt,
            country,
            COUNT(state) AS trans_count,
            SUM(amount) AS trans_total_amount
     FROM transactions
     GROUP BY TO_CHAR(trans_date, 'yyyy-MM'), country) t1
LEFT JOIN
    (SELECT TO_CHAR(trans_date, 'yyyy-MM') AS mnt,
            country,
            COUNT(state) AS approved_count,
            SUM(amount) AS approved_total_amount
     FROM transactions
     WHERE state = 'approved'
     GROUP BY TO_CHAR(trans_date, 'yyyy-MM'), country) t2
ON t1.mnt = t2.mnt AND t1.country = t2.country;
