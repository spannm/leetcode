package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-gap/">164. Maximum Gap</a>.
 */
class Problem0164 extends LeetcodeProblem {

    int maximumGap(int[] _nums) {
        final int len = _nums.length;
        if (len < 2) {
            return 0;
        }

        Arrays.sort(_nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len;) {
            while (i < len && _nums[i] == _nums[i - 1]) {
                i++;
            }
            if (i == len) {
                i--;
                max = Math.max(_nums[i] - _nums[i - 1], max);
                break;
            } else {
                max = Math.max(_nums[i] - _nums[i - 1], max);
            }
            if (_nums[i] != _nums[i - 1]) {
                i++;
            }
        }
        return max;
    }

}
