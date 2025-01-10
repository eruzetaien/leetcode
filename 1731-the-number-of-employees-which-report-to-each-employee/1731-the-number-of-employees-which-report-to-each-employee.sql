# Write your MySQL query statement below
SELECT 
    E.reports_to as employee_id,
    EN.name,
    COUNT(E.employee_id) AS reports_count,
    ROUND(AVG(E.age)) AS average_age
FROM Employees AS E
LEFT JOIN (
    SELECT 
        employee_id,
        name
    FROM Employees
) AS EN
ON E.reports_to = EN.employee_id 
WHERE reports_to IS NOT NULL
GROUP BY reports_to
ORDER BY reports_to;