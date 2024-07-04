package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 597. Friend Requests I Overall Acceptance Rate.
 */
public class Problem0597 extends LeetcodeSqlProblem {

    Problem0597() {
        super("""
            SELECT
                ROUND( IFNULL(
                (   SELECT
                        COUNT(DISTINCT requester_id, accepter_id)
                    FROM
                        RequestAccepted ) /
                (   SELECT
                        COUNT(DISTINCT sender_id, send_to_id)
                    FROM
                        FriendRequest), 0 ), 2 ) AS accept_rate""");
    }

}
