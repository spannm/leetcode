package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 579. Find Cumulative Salary of an Employee.
 */
public class Problem0579 extends LeetcodeSqlProblem {

    Problem0579() {
        super("""
            SELECT
                id,
                MONTH,
                SUM(salary) OVER (
                  PARTITION BY
                      id
                  ORDER BY
                      MONTH RANGE 2 PRECEDING ) AS Salary
            FROM
                employee
            WHERE
                (
                    id,
                    MONTH)
                NOT IN
                (   SELECT
                        id,
                        MAX(MONTH)
                    FROM
                        Employee
                    GROUP BY
                        id )
            ORDER BY
                id,
                MONTH DESC""");
    }

}
