package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0550 extends LeetcodeSqlProblem {

    Problem0550() {
        super("""
            WITH
                T AS (
                    SELECT
                        player_id,
                        DATEDIFF(
                            LEAD(event_date) OVER (
                                PARTITION BY player_id
                                ORDER BY event_date
                            ),
                            event_date
                        ) = 1 AS st,
                        RANK() OVER (
                            PARTITION BY player_id
                            ORDER BY event_date
                        ) AS rk
                    FROM Activity
                )
            SELECT ROUND(COUNT(IF(st = 1, player_id, NULL)) / COUNT(DISTINCT player_id), 2) AS fraction
            FROM T
            WHERE rk = 1""");
    }

}
