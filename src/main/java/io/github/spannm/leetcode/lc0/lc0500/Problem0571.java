package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 571. Find Median Given Frequency of Numbers.
 */
public class Problem0571 extends LeetcodeSqlProblem {

    Problem0571() {
        super("""
WITH
t AS (
SELECT
*,
SUM(frequency) OVER (ORDER BY num ASC) AS rk1,
SUM(frequency) OVER (ORDER BY num DESC) AS rk2,
SUM(frequency) OVER () AS s
FROM Numbers
)
SELECT
ROUND(AVG(num), 1) AS median
FROM t
WHERE rk1 >= s / 2 AND rk2 >= s / 2""");
    }

}
