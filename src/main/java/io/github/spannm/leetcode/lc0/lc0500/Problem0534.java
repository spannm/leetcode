package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 534. Game Play Analysis III.
 */
public class Problem0534 extends LeetcodeSqlProblem {

    Problem0534() {
        super("""
SELECT
player_id,
event_date,
SUM(games_played) OVER (
PARTITION BY player_id
ORDER BY event_date
) AS games_played_so_far
FROM Activity""");
    }

}
