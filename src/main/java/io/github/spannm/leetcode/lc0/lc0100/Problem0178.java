package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * <a href="https://leetcode.com/problems/rank-scores/">178. Rank Scores</a>.
 */
public class Problem0178 extends LeetcodeSqlProblem {

    Problem0178() {
        super("""
            SELECT
                score,
                dense_rank() OVER(ORDER BY score DESC) AS 'rank'
            FROM
                Scores""");
    }

}
