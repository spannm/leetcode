package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/">2616. Minimize the Maximum
 * Difference of Pairs</a>.
 */
class Problem2616 extends LeetcodeProblem {

    int minimizeMax(int[] _nums, int _pairCount) {
        if (_pairCount == 0) {
            return 0;
        }

        final int len = _nums.length;
        Arrays.sort(_nums);

        int left = 0;
        int right = _nums[len - 1];
        int res = right;

        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (isValid(_nums, len, mid, _pairCount)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }

        _nums = null;
        System.gc();

        return res;
    }

    private static boolean isValid(int[] _nums, int _n, int _threshold, int _pairCount) {
        int count = 0;
        int i = 0;
        while (i < _n - 1) {
            if (Math.abs(_nums[i] - _nums[i + 1]) <= _threshold) {
                if (++count == _pairCount) {
                    return true;
                }
                i += 2;
            } else {
                i++;
            }
        }
        return false;
    }

}
