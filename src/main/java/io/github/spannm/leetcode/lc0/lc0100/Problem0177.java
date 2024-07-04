package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * <a href="https://leetcode.com/problems/nth-highest-salary/">177. Nth Highest Salary</a>.
 */
public class Problem0177 extends LeetcodeSqlProblem {

    Problem0177() {
        super("""
            SELECT MAX(Salary) AS SecondHighestSalary
            FROM Employee
            WHERE Salary < (SELECT MAX(Salary) FROM Employee)""");
    }

}
