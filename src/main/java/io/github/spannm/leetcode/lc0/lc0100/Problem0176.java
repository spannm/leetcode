package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * <a href="https://leetcode.com/problems/second-highest-salary/">176. Second Highest Salary</a>.
 */
public class Problem0176 extends LeetcodeSqlProblem {

    Problem0176() {
        super("""
            CREATE FUNCTION getNthHighestSalary(n INT) RETURNS INT
            BEGIN
            SET n = n - 1;
              RETURN (
                  SELECT DISTINCT(salary) FROM Employee ORDER BY salary DESC LIMIT 1 OFFSET n
              );
            END""");
    }

}
