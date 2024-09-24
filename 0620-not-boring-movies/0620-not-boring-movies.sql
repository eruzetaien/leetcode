# Write your MySQL query statement below
SELECT * 
FROM Cinema
WHERE description NOT IN (
    SELECT description
    FROM Cinema
    WHERE id % 2 = 0 OR description LIKE '%boring%' 
)
ORDER BY rating DESC