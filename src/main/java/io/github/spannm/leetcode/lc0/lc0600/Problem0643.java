package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0643 extends LeetcodeProblem {

    double findMaxAverage(int[] _nums, int _k) {
        double sum = 0;
        double maxAvg = Integer.MIN_VALUE;
        for (int i = 0; i < _nums.length; i++) {
            if (_k <= i) {
                sum -= _nums[i - _k];
            }
            sum += _nums[i];
            if (i + 1 >= _k) {
                maxAvg = Math.max(maxAvg, sum / _k);
            }
        }
        return maxAvg;
    }

}
