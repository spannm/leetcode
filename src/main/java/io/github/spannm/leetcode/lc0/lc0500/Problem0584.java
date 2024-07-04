package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0584 extends LeetcodeSqlProblem {

    Problem0584() {
        super("""
            SELECT
                name
            FROM
                Customer
            WHERE
                IFNULL(referee_id, 0) != 2""");
    }

}
