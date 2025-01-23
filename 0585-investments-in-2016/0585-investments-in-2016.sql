# Write your MySQL query statement below
SELECT ROUND(SUM(I1.tiv_2016),2) AS tiv_2016
FROM Insurance AS I1
WHERE 
    NOT EXISTS (
        SELECT I2.pid 
        FROM Insurance AS I2 
        WHERE I2.pid != I1.pid AND
            I1.lat = I2.lat AND
            I1.lon = I2.lon 
    )
    AND
    EXISTS (
        SELECT I3.pid 
        FROM Insurance AS I3 
        WHERE I3.pid != I1.pid AND
            I3.tiv_2015 = I1.tiv_2015
    )  
