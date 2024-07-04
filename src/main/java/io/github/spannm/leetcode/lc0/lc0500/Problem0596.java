package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 596. Classes More Than 5 Students.
 */
public class Problem0596 extends LeetcodeSqlProblem {

    Problem0596() {
        super("""
SELECT class
FROM Courses
GROUP BY 1
HAVING COUNT(1) >= 5""");
    }

}
