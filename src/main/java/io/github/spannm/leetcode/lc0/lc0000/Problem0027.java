package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/remove-element/">27. Remove Element</a>.
 */
class Problem0027 extends LeetcodeProblem {

    int removeElement(int[] _nums, int _val) {
        final int len = _nums.length;
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (_nums[j] != _val) {
                _nums[i++] = _nums[j];
            }
        }
        return i;
    }

}
