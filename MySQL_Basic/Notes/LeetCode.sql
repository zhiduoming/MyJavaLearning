-- leetcode 176.第二高的薪水
SELECT (SELECT DISTINCT salary
        FROM employee e
        ORDER BY e.salary DESC
        LIMIT 1,1) AS secondhighestsalary;

-- leetcode 175.组合两个表
SELECT p.firstname,p.lastname,a.city,a.state
FROM person p,
LEFT JOIN Address a ON p.PersonId= a.PersonId;