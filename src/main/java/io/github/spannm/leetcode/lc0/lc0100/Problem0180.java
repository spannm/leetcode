package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * <a href="https://leetcode.com/problems/consecutive-numbers/">180. Consecutive Numbers</a>.
 */
public class Problem0180 extends LeetcodeSqlProblem {

    Problem0180() {
        super("""
            SELECT
                DISTINCT a.num ConsecutiveNums
            FROM
                logs a
            INNER JOIN
                logs b
            ON
                a.id = b.id-1
            INNER JOIN
                logs c
            ON
                b.id = c.id-1
            WHERE
                a.num = b.num
            AND b.num = c.num""");
    }

}
