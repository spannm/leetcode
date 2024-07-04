package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0262 extends LeetcodeSqlProblem {

    Problem0262() {
        super("""
            SELECT
                request_at DAY,
                ROUND(SUM(
                CASE
                    WHEN status = 'cancelled_by_driver'
                    OR  status = 'cancelled_by_client'
                    THEN 1
                    ELSE 0
                END) / (COUNT(id) * 1.00), 2) 'Cancellation Rate'
            FROM
                Trips t
            WHERE
                request_at BETWEEN '2013-10-01' AND '2013-10-03'
            AND client_id IN
                (   SELECT
                        users_id
                    FROM
                        Users
                    WHERE
                        banned = 'No')
            AND driver_id IN
                (   SELECT
                        users_id
                    FROM
                        Users
                    WHERE
                        banned = 'No')
            GROUP BY
                request_at""");
    }

}
