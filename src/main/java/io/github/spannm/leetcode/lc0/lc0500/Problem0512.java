package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 512. Game Play Analysis II.
 */
public class Problem0512 extends LeetcodeSqlProblem {

    Problem0512() {
        super("""
SELECT
player_id,
device_id
FROM Activity
WHERE
(player_id, event_date) IN (
SELECT
player_id,
MIN(event_date) AS event_date
FROM Activity
GROUP BY 1
)""");
    }

}
