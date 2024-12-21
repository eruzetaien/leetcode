# Write your MySQL query statement below
SELECT p_table.id
FROM Weather AS p_table
JOIN Weather AS c_table
ON DATE(p_table.recordDate) = DATE(c_table.recordDate + INTERVAL 1 DAY)
WHERE p_table.temperature > c_table.temperature;