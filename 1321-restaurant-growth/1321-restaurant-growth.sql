/* Write your T-SQL query statement below */

WITH Daily AS (
    SELECT 
        visited_on,
        SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
),
WindowCalc AS (
    SELECT
        visited_on,
        SUM(amount) OVER (
            ORDER BY visited_on
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        AVG(amount * 1.0) OVER (
            ORDER BY visited_on
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS avg7
    FROM Daily
)
SELECT
    visited_on,
    amount,
    ROUND(avg7, 2) AS average_amount
FROM WindowCalc
WHERE visited_on >= (
    SELECT DATEADD(DAY, 6, MIN(visited_on)) FROM Daily
)
ORDER BY visited_on;



