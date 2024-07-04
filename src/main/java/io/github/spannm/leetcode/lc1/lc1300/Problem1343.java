package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1343 extends LeetcodeProblem {

    int numOfSubarrays(int[] _arr, int _k, int _threshold) {
        int sum = 0;
        for (int i = 0; i < _k - 1; i++) {
            sum += _arr[i];
        }
        int count = 0;
        for (int i = _k - 1; i < _arr.length; i++) {
            sum += _arr[i];
            if (i - _k >= 0) {
                sum -= _arr[i - _k];
            }
            if (sum / _k >= _threshold) {
                count++;
            }
        }
        return count;
    }

}
