package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 181. Employees Earning More Than Their Managers.
 */
public class Problem0181 extends LeetcodeSqlProblem {

    Problem0181() {
        super("""
            SELECT
                Name AS Employee
            FROM
                Employee AS Curr
            WHERE
                Salary >
                (   SELECT
                        Salary
                    FROM
                        Employee
                    WHERE
                        Id = Curr.ManagerId )""");
    }

}
