package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0585 extends LeetcodeSqlProblem {

    Problem0585() {
        super("""
            WITH
                T AS (
                    SELECT
                        tiv_2016,
                        COUNT(1) OVER (PARTITION BY tiv_2015) AS count1,
                        COUNT(1) OVER (PARTITION BY lat, lon) AS count2
                    FROM Insurance
                )
            SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
            FROM T
            WHERE count1 > 1 AND count2 = 1""");
    }

}
