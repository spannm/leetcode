package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 184. Department Highest Salary.
 */
public class Problem0184 extends LeetcodeSqlProblem {

    Problem0184() {
        super("""
            SELECT
                d.name AS department,
                e.name AS employee,
                salary
            FROM
                Employee AS e
            JOIN
                Department AS d
            ON
                e.departmentId = d.id
            WHERE
                (
                    d.id,
                    salary)
                IN
                (   SELECT
                        departmentId,
                        MAX(salary)
                    FROM
                        Employee
                    GROUP BY
                        1 )""");
    }

}
