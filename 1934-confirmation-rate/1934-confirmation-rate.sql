# Write your MySQL query statement below
SELECT S.user_id, ROUND(COALESCE(total_confirmed/COUNT(S.user_id), 0),2) AS confirmation_rate
FROM Signups AS S
LEFT JOIN Confirmations AS C
ON S.user_id = C.user_id
LEFT JOIN (
    SELECT CT.user_id, Count(CT.action) AS total_confirmed
    FROM Confirmations AS CT
    WHERE CT.action = "confirmed"
    GROUP BY CT.user_id
) As CT
ON CT.user_id = S.user_id
GROUP BY S.user_id