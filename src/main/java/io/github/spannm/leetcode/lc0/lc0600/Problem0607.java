package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 607. Sales Person.
 */
public class Problem0607 extends LeetcodeSqlProblem {

    Problem0607() {
        super("""
            SELECT
                sp.name
            FROM
                SalesPerson AS sp
            LEFT JOIN
                Orders
            USING
                (sales_id)
            LEFT JOIN
                Company AS c
            USING
                (com_id)
            GROUP BY
                sales_id
            HAVING
                IFNULL(SUM(c.name = 'RED'), 0) = 0""");
    }

}
