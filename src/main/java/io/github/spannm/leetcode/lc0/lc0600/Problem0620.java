package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 620. Not Boring Movies.
 */
public class Problem0620 extends LeetcodeSqlProblem {

    Problem0620() {
        super("""
            SELECT
                *
            FROM
                Cinema
            WHERE
                description != 'boring'
            AND id & 1 = 1
            ORDER BY
                4 DESC""");
    }

}
