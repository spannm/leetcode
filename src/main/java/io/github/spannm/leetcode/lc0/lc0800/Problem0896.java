package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/monotonic-array/">896. Monotonic Array</a>.
 */
class Problem0896 extends LeetcodeProblem {

    boolean isMonotonic(int[] _nums) {
        if (_nums.length <= 2) {
            return true;
        }
        Boolean ascending = null;
        for (int i = 1; i < _nums.length; i++) {
            if (_nums[i - 1] != _nums[i]) {
                if (ascending == null) {
                    ascending = _nums[i - 1] < _nums[i];
                } else if (_nums[i - 1] < _nums[i] != ascending) {
                    return false;
                }
            }
        }
        return true;
    }

}
