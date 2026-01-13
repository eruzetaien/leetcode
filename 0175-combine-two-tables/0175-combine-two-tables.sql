/* Write your T-SQL query statement below */
SELECT 
    P.firstName,
    P.LastName,
    A.City,
    A.state
FROM Person AS P
LEFT JOIN Address AS A
    ON P.personId = A.personId

