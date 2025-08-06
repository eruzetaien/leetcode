-- Write your PostgreSQL query statement below
WITH LatestPrice AS (
    SELECT DISTINCT ON (product_id)
        product_id,
        new_price
    FROM Products
    WHERE change_date <= '2019-08-16'
    ORDER BY product_id, change_date DESC
),
AllProducts AS (
    SELECT DISTINCT product_id FROM Products
)

SELECT
    ap.product_id,
    COALESCE(lp.new_price, 10) AS price
FROM AllProducts ap
LEFT JOIN LatestPrice lp ON ap.product_id = lp.product_id;