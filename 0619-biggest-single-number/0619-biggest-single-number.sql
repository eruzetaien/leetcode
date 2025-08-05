-- Write your PostgreSQL query statement below
SELECT MAX(single_num) as num
FROM (
    SELECT num AS single_num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
)