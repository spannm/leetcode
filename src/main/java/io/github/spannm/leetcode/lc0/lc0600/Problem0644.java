package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0644 extends LeetcodeProblem {

    double findMaxAverage(int[] _nums, int _k) {
        double l = -10000;
        double r = 10000;
        while (r - l > 10e-7) {
            double mid = (l + r) / 2;
            if (getMaxSubbaraySumOfSizeK(_nums, _k, mid) >= 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return (l + r) / 2;
    }

    private double getMaxSubbaraySumOfSizeK(int[] _nums, int _k, double _mid) {
        double sum = 0.0;
        for (int i = 0; i <= _k - 1; i++) {
            sum += _nums[i] - _mid;
        }
        double maxSum = sum;
        double prev = _nums[0] - _mid;
        for (int i = _k; i < _nums.length; i++) {
            sum = sum - _nums[i - _k] + _nums[i];
            maxSum = Math.max(maxSum, Math.max(sum, sum + prev));
            prev = Math.max(_nums[i - _k + 1], _nums[i - _k + 1] + prev) - _mid;
        }
        return maxSum;
    }

}
