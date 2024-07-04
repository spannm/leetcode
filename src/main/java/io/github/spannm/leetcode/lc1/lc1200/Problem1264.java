package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 1264. Page Recommendations.
 */
public class Problem1264 extends LeetcodeSqlProblem {

    Problem1264() {
        super("""
            WITH
                T AS
                (   SELECT
                        user1_id AS user_id
                    FROM
                        Friendship
                    WHERE
                        user2_id = 1

                    UNION

                    SELECT
                        user2_id AS user_id
                    FROM
                        Friendship
                    WHERE
                        user1_id = 1
                )
            SELECT
                DISTINCT page_id AS recommended_page
            FROM
                T
            JOIN
                Likes
            USING
                (user_id)
            WHERE
                page_id NOT IN
                (   SELECT
                        page_id
                    FROM
                        Likes
                    WHERE
                        user_id = 1)""");
    }

}
