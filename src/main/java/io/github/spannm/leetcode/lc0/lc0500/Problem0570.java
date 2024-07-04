package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

public class Problem0570 extends LeetcodeSqlProblem {

    Problem0570() {
        super("""
            SELECT name, bonus
            FROM
                Employee
                LEFT JOIN Bonus USING (empId)
            WHERE IFNULL(bonus, 0) < 1000""");
    }

}
