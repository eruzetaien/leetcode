/* Write your T-SQL query statement below */
SELECT ROUND(SUM(tiv_2016),2) AS tiv_2016 
FROM Insurance AS I
WHERE NOT EXISTS (
        SELECT 1
        FROM Insurance
        WHERE I.pid != pid 
            AND (I.lat = lat AND I.lon = lon) 
    ) 
    AND EXISTS (
        SELECT 1
        FROM Insurance
        WHERE I.pid != pid 
            AND I.tiv_2015 = tiv_2015  
    )
