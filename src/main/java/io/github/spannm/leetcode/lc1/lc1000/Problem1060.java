package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1060. Missing Element in Sorted Array.
 */
class Problem1060 extends LeetcodeProblem {

    int missingElement(int[] _nums, int _k) {
        int n = _nums.length;
        if (_k > missing(_nums, n - 1)) {
            return _nums[n - 1] + _k - missing(_nums, n - 1);
        }
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (missing(_nums, mid) >= _k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return _nums[l - 1] + _k - missing(_nums, l - 1);
    }

    static int missing(int[] _nums, int _i) {
        return _nums[_i] - _nums[0] - _i;
    }

}
