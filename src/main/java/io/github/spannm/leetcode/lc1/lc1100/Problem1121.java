package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1121. Divide Array Into Increasing Sequences.
 */
class Problem1121 extends LeetcodeProblem {

    boolean canDivideIntoSubsequences(int[] _nums, int _k) {
        int cnt = 0;
        int a = 0;
        for (int b : _nums) {
            cnt = a == b ? cnt + 1 : 1;
            if (cnt * _k > _nums.length) {
                return false;
            }
            a = b;
        }
        return true;
    }

}
