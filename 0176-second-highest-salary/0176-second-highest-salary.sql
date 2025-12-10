/* Write your T-SQL query statement below */
SELECT 
    CASE 
        WHEN (
            SELECT COUNT(DISTINCT salary)
            FROM Employee
        ) >= 2 THEN (
            SELECT TOP 1 Salary
            FROM Employee
            WHERE Salary NOT IN (
                SELECT Max(Salary)
                FROM Employee
            )
            ORDER BY Salary DESC
        )
        ELSE NULL
    END AS SecondHighestSalary
