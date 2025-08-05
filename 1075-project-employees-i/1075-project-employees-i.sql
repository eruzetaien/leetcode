-- Write your PostgreSQL query statement below
SELECT project_id, ROUND(AVG(e.experience_years) * 1.0, 2) AS average_years
FROM Project AS p
JOIN Employee AS e
ON P.employee_id = e.employee_id
GROUP BY project_id

