# Write your MySQL query statement below
SELECT 
    Q.query_name,
    ROUND(AVG(Q.rating/Q.position),2) AS quality,
    COALESCE(ROUND(LR.low_rating/COUNT(Q.query_name) * 100.0,2),0) AS poor_query_percentage
FROM 
    Queries AS Q
LEFT JOIN 
    (
        SELECT DISTINCT query_name, COUNT(rating) AS low_rating
        FROM Queries
        WHERE rating < 3
        GROUP BY query_name
    ) AS LR
ON LR.query_name = Q.query_name
GROUP BY Q.query_name