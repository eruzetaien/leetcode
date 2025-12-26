/* Write your T-SQL query statement below */
SELECT 
    sell_date, 
    COUNT(DISTINCT product) AS num_sold,
     STRING_AGG(product, ',') 
        WITHIN GROUP (ORDER BY product) AS products
FROM (
    SELECT DISTINCT sell_date, product
    FROM Activities
) AS t
GROUP BY sell_date