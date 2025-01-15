-- Write your PostgreSQL query statement below
WITH recent_changes AS (
    SELECT 
        product_id,
        new_price,
        change_date
    FROM 
        Products
    WHERE 
        change_date <= '2019-08-16'
),
latest_change AS (
    SELECT 
        product_id,
        MAX(change_date) AS latest_date
    FROM 
        recent_changes
    GROUP BY 
        product_id
),
prices_on_date AS (
    SELECT 
        rc.product_id,
        rc.new_price
    FROM 
        recent_changes rc
    JOIN 
        latest_change lc
    ON 
        rc.product_id = lc.product_id 
        AND rc.change_date = lc.latest_date
)
SELECT 
    p.product_id,
    COALESCE(pod.new_price, 10) AS price
FROM 
    (SELECT DISTINCT product_id FROM Products) p
LEFT JOIN 
    prices_on_date pod
ON 
    p.product_id = pod.product_id;
