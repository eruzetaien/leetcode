# Write your MySQL query statement below
SELECT id 
FROM Weather as p_table
WHERE temperature > (
    SELECT c_table.temperature
    FROM Weather as c_table
    WHERE c_table.recordDate = DATE(p_table.recordDate) - INTERVAL 1 DAY
    LIMIT 1
);