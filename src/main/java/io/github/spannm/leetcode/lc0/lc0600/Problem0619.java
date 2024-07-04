package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 619. Biggest Single Number.
 */
public class Problem0619 extends LeetcodeSqlProblem {

    Problem0619() {
        super("""
            SELECT
                MAX(num) AS num
            FROM
                (SELECT
                     num
                 FROM
                     MyNumbers
                 GROUP BY
                     1
                 HAVING
                     COUNT(1) = 1 ) AS t""");
    }

}
