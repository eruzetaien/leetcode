-- Write your PostgreSQL query statement below
SELECT 
    ROUND(1.0 * COUNT(DISTINCT a1.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM Activity AS a1 
JOIN 
    (
        SELECT player_id, MIN(event_date) AS first_date
        FROM Activity
        GROUP BY player_id
    ) AS a2
ON a1.player_id = a2.player_id AND a1.event_date = a2.first_date + INTERVAL '1 day'
