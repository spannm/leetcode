package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">1658. Minimum Operations to Reduce X
 * to Zero</a>.
 */
class Problem1658 extends LeetcodeProblem {

    int minOperations(final int[] _nums, final int _x) {
        int sum = Arrays.stream(_nums).sum();
        int target = sum - _x;
        int len = _nums.length;
        int size = Integer.MIN_VALUE;
        for (int left = -1, right = 0, windowSum = 0; right < len; right++) {
            windowSum += _nums[right];
            while (left + 1 < len && windowSum > target) {
                left++;
                windowSum -= _nums[left];
            }
            if (windowSum == target) {
                size = Math.max(size, right - left);
            }
        }
        return size < 0 ? -1 : len - size;
    }

}
