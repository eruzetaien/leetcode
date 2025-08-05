-- Write your PostgreSQL query statement below
SELECT
    e.employee_id,
    e.name,
    m.count AS reports_count,
    ROUND(m.avg_age) AS average_age
FROM Employees AS e
JOIN
    (
        SELECT reports_to AS manager_id, COUNT(reports_to) AS count, AVG(age) avg_age
        FROM Employees
        WHERE reports_to IS NOT NULL
        GROUP BY reports_to
    ) AS m
ON e.employee_id = m.manager_id
ORDER BY e.employee_id