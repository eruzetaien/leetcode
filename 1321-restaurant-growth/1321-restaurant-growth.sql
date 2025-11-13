/* Write your T-SQL query statement below */

WITH Daily AS (
    SELECT 
        visited_on,
        SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
)
SELECT 
    d1.visited_on,
    w.sum_amount AS amount,
    ROUND(w.avg_amount, 2) AS average_amount
FROM Daily d1
OUTER APPLY (
    SELECT 
        SUM(d2.amount) AS sum_amount,
        AVG(d2.amount * 1.0) AS avg_amount
    FROM Daily d2
    WHERE d2.visited_on BETWEEN DATEADD(DAY, -6, d1.visited_on) AND d1.visited_on
) w
WHERE DATEDIFF(DAY, (SELECT MIN(visited_on) FROM Daily), d1.visited_on) >= 6
ORDER BY d1.visited_on;
