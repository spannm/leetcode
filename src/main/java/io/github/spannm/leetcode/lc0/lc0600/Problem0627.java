package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 627. Swap Salary.
 */
public class Problem0627 extends LeetcodeSqlProblem {

    Problem0627() {
        super("""
            UPDATE
                salary
            SET
                sex =
                CASE sex
                    WHEN 'm'
                    THEN 'f'
                    ELSE 'm'
                END""");
    }

}
