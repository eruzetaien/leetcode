-- Write your PostgreSQL query statement below
WITH AllProducts AS (
    SELECT DISTINCT product_id
    FROM Products
),
ProductLastUpdate AS (
    SELECT product_id, MAX(change_date) AS last_change_date
    FROM Products
    WHERE change_date <= DATE('2019-08-16')
    GROUP BY product_id
)

SELECT 
    ap.product_id, 
    COALESCE(p.new_price, 10) AS price
FROM AllProducts AS ap
LEFT JOIN ProductLastUpdate AS lu
    ON ap.product_id = lu.product_id 
LEFT JOIN Products AS p
    ON ap.product_id = p.product_id AND p.change_date = lu.last_change_date 
