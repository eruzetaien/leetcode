/* Write your T-SQL query statement below */
WITH cte AS (
    SELECT
        id,
        email,
        rn = ROW_NUMBER() OVER (PARTITION BY email ORDER BY id)
    FROM Person
)
DELETE FROM cte
WHERE rn > 1;
