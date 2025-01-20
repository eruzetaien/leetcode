# Write your MySQL query statement below
WITH DailyTotals AS (
    SELECT 
        visited_on,
        SUM(amount) AS amount
    FROM 
        Customer
    GROUP BY 
        visited_on
    ORDER BY 
        visited_on
)
SELECT 
    a.visited_on,
    SUM(b.amount) AS amount,
    ROUND(AVG(b.amount), 2) AS average_amount
FROM 
    DailyTotals a
JOIN 
    DailyTotals b
ON 
    b.visited_on BETWEEN DATE_ADD(a.visited_on, INTERVAL -6 DAY) AND a.visited_on
GROUP BY 
    a.visited_on
HAVING 
    COUNT(b.amount) >= 7
ORDER BY 
    a.visited_on;
