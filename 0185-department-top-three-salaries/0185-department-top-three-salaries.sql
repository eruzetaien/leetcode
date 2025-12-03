/* Write your T-SQL query statement below */
SELECT D.Name AS Department
    , E.name AS Employee 
    , E.salary AS Salary
FROM Employee AS E
JOIN Department AS D
    ON E.departmentId = D.id
WHERE (
        SELECT COUNT(DISTINCT salary)
        FROM Employee
        WHERE id != E.id 
            AND salary > E.salary
            AND departmentId = E.DepartmentId
    ) < 3
