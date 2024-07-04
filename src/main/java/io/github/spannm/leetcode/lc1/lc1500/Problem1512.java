package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-good-pairs/">1512. Number of Good Pairs</a>.
 */
class Problem1512 extends LeetcodeProblem {

    int numIdenticalPairs(int[] _nums) {
        final int len = _nums.length;
        int count = 0;
        for (int i1 = 0; i1 < len; i1++) {
            for (int i2 = i1 + 1; i2 < len; i2++) {
                if (_nums[i1] == _nums[i2]) {
                    count++;
                }
            }
        }
        return count;
    }

}
