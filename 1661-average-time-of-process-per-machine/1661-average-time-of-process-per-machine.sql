# Write your MySQL query statement below
SELECT p_table.machine_id, ROUND(AVG(ABS(p_table.timestamp - c_table.timestamp)),3) AS processing_time
FROM Activity as p_table 
JOIN Activity as c_table
ON p_table.machine_id = c_table.machine_id AND
    p_table.process_id = c_table.process_id AND
    p_table.activity_type != c_table.activity_type
GROUP BY p_table.machine_id;