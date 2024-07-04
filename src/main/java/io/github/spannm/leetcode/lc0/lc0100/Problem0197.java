package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * <a href="https://leetcode.com/problems/rising-temperature/">197. Rising Temperature</a>.
 */
public class Problem0197 extends LeetcodeSqlProblem {

    Problem0197() {
        super("""
            SELECT
                w1.id
            FROM
                Weather AS w1,
                Weather AS w2
            WHERE
                DATEDIFF(w1.RecordDate, w2.RecordDate) = 1
            AND w1.Temperature > w2.Temperature""");
    }

}
