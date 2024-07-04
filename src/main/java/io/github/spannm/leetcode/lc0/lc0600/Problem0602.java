package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 602. Friend Requests II Who Has the Most Friends.
 */
public class Problem0602 extends LeetcodeSqlProblem {

    Problem0602() {
        super("""
            WITH
                T AS
                (   SELECT
                        requester_id,
                        accepter_id
                    FROM
                        RequestAccepted

                    UNION

                    SELECT
                        accepter_id,
                        requester_id
                    FROM
                        RequestAccepted
                )
            SELECT
                requester_id       AS id,
                COUNT(accepter_id) AS num
            FROM
                T
            GROUP BY
                1
            ORDER BY
                2 DESC LIMIT 1""");
    }

}
