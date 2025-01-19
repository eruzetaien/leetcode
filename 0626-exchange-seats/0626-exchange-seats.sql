# Write your MySQL query statement below
WITH OddPositionNumbers AS (
    SELECT student, ROW_NUMBER() OVER (ORDER BY id) AS row_num
    FROM Seat
    WHERE id % 2 = 1
),
EvenPositionNumbers AS (
    SELECT student, ROW_NUMBER() OVER (ORDER BY id) AS row_num
    FROM Seat
    WHERE id % 2 = 0
),
Combined AS (
    SELECT row_num, student, 'Table2' AS source FROM OddPositionNumbers
    UNION ALL
    SELECT row_num, student, 'Table1' AS source FROM EvenPositionNumbers
)
SELECT ROW_NUMBER() OVER (ORDER BY row_num, source) AS id,  student
FROM Combined
ORDER BY row_num, source;