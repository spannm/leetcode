package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/single-number-ii/">137. Single Number II</a>.
 */
class Problem0137 extends LeetcodeProblem {

    int singleNumber(int[] _nums) {
        int o = 0;
        int t = 0;
        for (int num : _nums) {
            o = (num ^ o) & ~t;
            t = (num ^ t) & ~o;
        }
        return o;
    }

}
