# Write your MySQL query statement below
SELECT 
    ROUND(
        COUNT(DISTINCT A2.player_id) / COUNT(DISTINCT A1.player_id), 2
    ) AS fraction
FROM 
    (SELECT 
         player_id, 
         MIN(event_date) AS first_date
     FROM Activity
     GROUP BY player_id) AS A1
LEFT JOIN Activity AS A2
ON A2.event_date = DATE_ADD(A1.first_date, INTERVAL 1 DAY) 
AND A1.player_id = A2.player_id;
