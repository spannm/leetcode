package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0511 extends LeetcodeSqlProblem {

    Problem0511() {
        super("""
            SELECT
                player_id,
                MIN(event_date) AS first_login
            FROM
                Activity
            GROUP BY
                player_id""");
    }

}
