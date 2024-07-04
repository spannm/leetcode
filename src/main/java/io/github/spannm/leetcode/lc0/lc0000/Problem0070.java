package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>.
 */
class Problem0070 extends LeetcodeProblem {

    int climbStairs(int _n) {
        if (_n == 1 || _n == 2) {
            return _n;
        }
        return climbStairs(_n - 2) + climbStairs(_n - 1);
    }

}
