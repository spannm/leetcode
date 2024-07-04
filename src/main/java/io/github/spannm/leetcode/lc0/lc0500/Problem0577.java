package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0577 extends LeetcodeSqlProblem {

    Problem0577() {
        super("""
            SELECT
                name
            FROM
                Employee
            JOIN
                (   SELECT
                        managerId AS id,
                        COUNT(1)  AS cnt
                    FROM
                        Employee
                    GROUP BY
                        1
                    HAVING
                        cnt >= 5 ) AS t
            USING
                (id)""");
    }

}
