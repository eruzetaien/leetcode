# Write your MySQL query statement below
SELECT 
    DATE_FORMAT(T.trans_date, '%Y-%m') AS month, 
    T.country, 
    COUNT(*) AS trans_count,
    COUNT(TA.trans_date) AS approved_count,
    COALESCE(SUM(T.amount),0) AS trans_total_amount,
    COALESCE(SUM(TA.amount),0) AS approved_total_amount
FROM 
    Transactions AS T
LEFT JOIN 
    (
        SELECT
            trans_date,
            country,
            amount
        FROM 
            Transactions 
        WHERE state = 'approved'
    ) AS TA
ON T.trans_date = TA.trans_date AND 
    COALESCE(T.country, 'Unknown') = COALESCE(TA.country, 'Unknown') AND 
    TA.amount = T.amount
GROUP BY 
    T.country, 
    DATE_FORMAT(T.trans_date, '%Y-%m')