package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 569. Median Employee Salary.
 */
public class Problem0569 extends LeetcodeSqlProblem {

    Problem0569() {
        super("""
WITH
t AS (
SELECT
*,
ROW_NUMBER() OVER (
PARTITION BY company
ORDER BY salary ASC
) AS rk,
COUNT(id) OVER (PARTITION BY company) AS n
FROM Employee
)
SELECT
id,
company,
salary
FROM t
WHERE rk >= n / 2 AND rk <= n / 2 + 1""");
    }

}
