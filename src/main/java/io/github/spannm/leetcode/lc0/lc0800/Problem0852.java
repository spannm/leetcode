package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">852. Peak Index in a Mountain Array</a>.
 */
class Problem0852 extends LeetcodeProblem {

    static int peakIndexInMountainArray(final int[] _arr) {
        final int len = _arr.length;
        int l = 0;
        int r = len - 1;
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (_arr[m] < _arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

}
