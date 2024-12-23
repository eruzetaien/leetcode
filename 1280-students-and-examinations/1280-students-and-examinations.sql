# Write your MySQL query statement below
SELECT 
    Std.student_id, 
    Std.student_name, 
    Sbj.subject_name, 
    COALESCE(COUNT(Exm.subject_name), 0) AS attended_exams
FROM Students AS Std
CROSS JOIN Subjects AS Sbj  -- Ensure all subjects for each student
LEFT JOIN Examinations AS Exm
    ON Std.student_id = Exm.student_id
    AND Sbj.subject_name = Exm.subject_name
GROUP BY Std.student_id, Std.student_name, Sbj.subject_name
ORDER BY Std.student_id, Std.student_name, Sbj.subject_name;
