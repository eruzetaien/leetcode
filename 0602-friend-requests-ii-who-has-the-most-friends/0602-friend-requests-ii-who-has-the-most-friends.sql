/* Write your T-SQL query statement below */

WITH FriendReqCount AS (
    SELECT 
        requester_id AS [user],
        COUNT(*) AS friendCount
    FROM RequestAccepted
    GROUP BY requester_id
), 
FriendAccCount AS (
    SELECT 
        accepter_id AS [user],
        COUNT(*) AS friendCount
    FROM RequestAccepted
    GROUP BY accepter_id
),
Combined AS (
    SELECT 
        COALESCE(FRC.[user], FAC.[user]) AS user_id,
        ISNULL(FRC.friendCount, 0) AS req_count,
        ISNULL(FAC.friendCount, 0) AS acc_count
    FROM FriendReqCount FRC
    FULL OUTER JOIN FriendAccCount FAC
        ON FRC.[user] = FAC.[user]
), Final AS (
    SELECT 
        user_id,
        req_count + acc_count AS total_friends
    FROM Combined
)
SELECT user_id [id], total_friends [num]
FROM Final
WHERE total_friends = (SELECT MAX(total_friends) FROM Final);
