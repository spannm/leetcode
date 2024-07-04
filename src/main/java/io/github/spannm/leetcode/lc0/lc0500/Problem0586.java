package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0586 extends LeetcodeSqlProblem {

    Problem0586() {
        super("""
            SELECT
                customer_number
            FROM
                orders
            GROUP BY
                customer_number
            ORDER BY
                COUNT(1) DESC LIMIT 1""");
    }

}
