package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * <a href="https://leetcode.com/problems/delete-duplicate-emails/">196. Delete Duplicate Emails</a>.
 */
public class Problem0196 extends LeetcodeSqlProblem {

    Problem0196() {
        super("""
            DELETE
                a
            FROM
                Person a,
                Person b
            WHERE
                a.email = b.email
            AND a.id > b.id""");
    }

}
