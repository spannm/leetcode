package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * <a href="https://leetcode.com/problems/combine-two-tables/">175. Combine Two Tables</a>.
 */
public class Problem0175 extends LeetcodeSqlProblem {

    Problem0175() {
        super("""
            SELECT p.firstName, p.lastName, a.city, a.state FROM Person p, Address a
            WHERE p.personId = a.personId
            UNION
            SELECT  p.firstName, p.lastName, null, null FROM Person p
            WHERE p.personId NOT IN (SELECT personId FROM Address)""");
    }

}
