package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 1350. Students With Invalid Departments.
 */
public class Problem1350 extends LeetcodeSqlProblem {

    Problem1350() {
        super("""
SELECT id, name
FROM Students
WHERE department_id NOT IN (SELECT id FROM Departments)""");
    }

}
