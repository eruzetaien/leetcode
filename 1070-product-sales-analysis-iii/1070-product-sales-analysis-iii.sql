# Write your MySQL query statement below
WITH FirstYearSales AS (
    SELECT
        product_id,
        MIN(year) AS first_year
    FROM Sales
    GROUP BY product_id
)

SELECT 
    S.product_id,
    F.first_year,
    S.quantity,
    S.price
FROM 
    Sales AS S
JOIN 
    FirstYearSales AS F
ON 
    S.product_id = F.product_id AND
    S.year = F.first_year