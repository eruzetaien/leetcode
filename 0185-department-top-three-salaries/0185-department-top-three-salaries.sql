# Write your MySQL query statement below
WITH UniqueSalary AS (
    SELECT DISTINCT
        departmentId,
        salary
    FROM Employee
),RankedSalary AS (
    SELECT 
        departmentId,
        salary,
        ROW_NUMBER() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS row_rank
    FROM UniqueSalary
), 
Top3Salary AS (
    SELECT
        departmentId,
        salary
    FROM RankedSalary
    WHERE row_rank <= 3
)
SELECT DISTINCT
    D.name AS Department,
    E.name AS Employee,
    E.salary AS Salary 
FROM Employee AS E
JOIN Top3Salary AS TS
    ON E.departmentId = TS.departmentId AND
        E.salary = TS.salary
JOIN Department AS D
    ON E.departmentId = D.id

    

