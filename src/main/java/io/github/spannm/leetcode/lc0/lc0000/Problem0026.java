package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">26. Remove Duplicates from Sorted
 * Array</a>.
 */
class Problem0026 extends LeetcodeProblem {

    int removeDuplicates(int[] _nums) {
        final int len = _nums.length;
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (_nums[i] != _nums[j]) {
                i++;
                _nums[i] = _nums[j];
            }
        }
        return i + 1;
    }

}
