package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/kth-missing-positive-number/">1539. Kth Missing Positive Number</a>.
 */
class Problem1539 extends LeetcodeProblem {

    int findKthPositive(int[] _arr, int _k) {
        int left = 0;
        int right = _arr.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (_arr[mid] - 1 - mid < _k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left + _k;
    }

}
