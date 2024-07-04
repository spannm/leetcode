package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimize-maximum-of-array/">2439. Minimize Maximum of Array</a>.
 */
class Problem2439 extends LeetcodeProblem {

    int minimizeArrayValue(int[] _nums) {
        final int len = _nums.length;
        long sum = 0;
        int min = 0;
        for (int index = 0; index < len; ++index) {
            sum += _nums[index];
            min = (int) Math.max(min, (sum + index) / (index + 1));
        }
        return min;
    }

}
