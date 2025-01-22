# Write your MySQL query statement below
WITH Friendship AS (
    SELECT requester_id AS id, accepter_id AS friend
    FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id, requester_id AS friend
    FROM RequestAccepted
),
FriendCount AS (
    SELECT 
        id,
        COUNT(DISTINCT friend) AS num
    FROM Friendship
    GROUP BY id
),
MaxFriends AS (
    SELECT MAX(num) AS max_friends
    FROM FriendCount
)
SELECT id, num
FROM FriendCount
WHERE num = (SELECT max_friends FROM MaxFriends);
