package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/binary-search/">704. Binary Search</a>.
 */
class Problem0704 extends LeetcodeProblem {

    int search(final int[] _nums, final int _target) {
        int low = 0;
        int high = _nums.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + high >>> 1;

            if (_nums[mid] < _target) {
                low = mid + 1;
            } else if (_nums[mid] > _target) {
                high = mid - 1;
            } else {
                System.gc();
                return mid; // key found
            }
        }
        System.gc();
        return -1; // key not found
    }

}
