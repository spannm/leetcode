package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 183. Customers Who Never Order.
 */
public class Problem0183 extends LeetcodeSqlProblem {

    Problem0183() {
        super("""
            SELECT
                name AS Customers
            FROM
                Customers
            WHERE
                id NOT IN
                (   SELECT
                        customerId
                    FROM
                        Orders )""");
    }

}
