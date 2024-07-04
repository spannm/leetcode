package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 603. Consecutive Available Seats.
 */
public class Problem0603 extends LeetcodeSqlProblem {

    Problem0603() {
        super("""
            SELECT
                DISTINCT a.seat_id
            FROM
                Cinema AS a
            JOIN
                Cinema AS b
            ON
                ABS(a.seat_id - b.seat_id) = 1
            AND a.free
            AND b.free
            ORDER BY
                1""");
    }

}
