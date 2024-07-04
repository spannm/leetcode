package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 185. Department Top Three Salaries.
 */
public class Problem0185 extends LeetcodeSqlProblem {

    Problem0185() {
        super("""
            SELECT
                Department.NAME AS Department,
                Employee.NAME   AS Employee,
                Salary
            FROM
                Employee,
                Department
            WHERE
                Employee.DepartmentId = Department.Id
            AND
                (   SELECT
                        COUNT(DISTINCT e2.Salary)
                    FROM
                        Employee AS e2
                    WHERE
                        e2.Salary > Employee.Salary
                    AND Employee.DepartmentId = e2.DepartmentId )
                < 3""");
    }

}
