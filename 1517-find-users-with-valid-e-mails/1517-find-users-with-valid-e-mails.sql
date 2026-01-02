/* Write your T-SQL query statement below */
SELECT user_id, name, mail
FROM Users
WHERE mail LIKE '[A-Za-z]%'
    AND mail COLLATE Latin1_General_BIN LIKE '%@leetcode.com'

  AND LEN(mail) - LEN(REPLACE(mail, '@', '')) = 1
  AND LEFT(mail, CHARINDEX('@', mail) - 1)
      NOT LIKE '%[^A-Za-z0-9_.-]%';
