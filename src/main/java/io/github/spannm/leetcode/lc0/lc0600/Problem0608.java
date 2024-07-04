package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 608. Tree Node.
 */
public class Problem0608 extends LeetcodeSqlProblem {

    Problem0608() {
        super("""
            SELECT
                id,
                CASE
                    WHEN p_id IS NULL
                    THEN 'Root'
                    WHEN id IN
                        (   SELECT
                                p_id
                            FROM
                                Tree)
                    THEN 'Inner'
                    ELSE 'Leaf'
                END AS type
            FROM
                Tree""");
    }

}
