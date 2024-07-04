package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 610. Triangle Judgement.
 */
public class Problem0610 extends LeetcodeSqlProblem {

    Problem0610() {
        super("""
            SELECT
                *,
                IF(x + y > z AND x + z > y AND y + z > x, 'Yes', 'No') AS triangle
            FROM
                Triangle""");
    }

}
