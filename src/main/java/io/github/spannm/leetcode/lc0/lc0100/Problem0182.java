package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 182. Duplicate Emails.
 */
public class Problem0182 extends LeetcodeSqlProblem {

    Problem0182() {
        super("""
            SELECT email
            FROM Person
            GROUP BY 1
            HAVING COUNT(1) > 1""");
    }

}
