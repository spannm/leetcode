package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 574. Winning Candidate.
 */
public class Problem0574 extends LeetcodeSqlProblem {

    Problem0574() {
        super("""
SELECT
Name
FROM
(
SELECT
CandidateId AS id
FROM Vote
GROUP BY CandidateId
ORDER BY COUNT(id) DESC
LIMIT 1
) AS t
INNER JOIN Candidate AS c ON t.id = c.id""");
    }

}
