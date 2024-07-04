package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 626. Exchange Seats.
 */
public class Problem0626 extends LeetcodeSqlProblem {

    Problem0626() {
        super("""
            SELECT
                s1.id,
                COALESCE(s2.student, s1.student) AS student
            FROM
                Seat AS s1
            LEFT JOIN
                Seat AS s2 ON (s1.id + 1) ^ 1 - 1 = s2.id
            ORDER BY 1""");
    }

}
