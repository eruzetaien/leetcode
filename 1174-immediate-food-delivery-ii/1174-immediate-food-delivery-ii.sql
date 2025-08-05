-- Write your PostgreSQL query statement below
SELECT 
    ROUND(
        SUM(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 
            ELSE 0 END) *100.0
            / COUNT(*), 
    2) AS immediate_percentage
FROM Delivery AS d
JOIN (
    SELECT customer_id, MIN(order_date) AS first_date
    FROM Delivery
    GROUP BY customer_id
) AS fd
ON d.customer_id = fd.customer_id AND d.order_date = fd.first_date 