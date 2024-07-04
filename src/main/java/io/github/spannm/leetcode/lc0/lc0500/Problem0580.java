package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 580. Count Student Number in Departments.
 */
public class Problem0580 extends LeetcodeSqlProblem {

    Problem0580() {
        super("""
            SELECT
                dept_name,
                COUNT(student_id) AS student_number
            FROM
                Department
            LEFT JOIN
                Student
            USING
                (dept_id)
            GROUP BY
                dept_id
            ORDER BY
                2 DESC,
                1""");
    }

}
