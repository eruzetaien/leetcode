# Write your MySQL query statement below
WITH SalaryCategory AS (
    SELECT 
        CASE 
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
            WHEN income > 50000 THEN 'High Salary'
            ELSE '' 
        END AS category
    FROM Accounts
), 
SalaryCategoryCount AS (
    SELECT 
        category,
        COUNT(*) AS accounts_count
    FROM SalaryCategory
    GROUP BY category
)

SELECT 
    SC.category,        
    COALESCE(SCC.accounts_count, 0) AS accounts_count
FROM (
    SELECT 'Low Salary' AS category
    UNION ALL
    SELECT 'Average Salary'
    UNION ALL
    SELECT 'High Salary'
) AS SC 
LEFT JOIN SalaryCategoryCount AS SCC
ON SC.category = SCC.category
