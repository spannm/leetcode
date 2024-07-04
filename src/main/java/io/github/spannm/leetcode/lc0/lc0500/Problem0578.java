package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 578. Get Highest Answer Rate Question.
 */
public class Problem0578 extends LeetcodeSqlProblem {

    Problem0578() {
        super("""
            SELECT
                question_id AS survey_log
            FROM
                SurveyLog
            GROUP BY
                1
            ORDER BY
                SUM(ACTION = 'answer') / SUM(ACTION = 'show') DESC,
                1
                LIMIT 1""");
    }

}
