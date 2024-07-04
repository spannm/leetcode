package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0595 extends LeetcodeSqlProblem {

    Problem0595() {
        super("""
            SELECT
                name,
                population,
                area
            FROM
                World
            WHERE
                area >= 3000000

            UNION

            SELECT
                name,
                population,
                area
            FROM
                World
            WHERE
                population >= 25000000""");
    }

}
