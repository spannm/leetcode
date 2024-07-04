package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0689 extends LeetcodeProblem {

    int[] maxSumOfThreeSubarrays(int[] _nums, int _k) {
        if (_nums == null || _nums.length == 0) {
            return new int[] {};
        }
        int n = _nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + _nums[i];
        }

        int[] leftMax = new int[n];
        for (int i = _k, total = sums[_k] - sums[0]; i < n; i++) {
            if (sums[i + 1] - sums[i + 1 - _k] > total) {
                leftMax[i] = i + 1 - _k;
                total = sums[i + 1] - sums[i + 1 - _k];
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }

        int[] rightMax = new int[n];
        rightMax[n - _k] = n - _k;
        for (int i = n - _k - 1, total = sums[n] - sums[n - _k]; i >= 0; i--) {
            if (sums[i + _k] - sums[i] >= total) {
                rightMax[i] = i;
                total = sums[i + _k] - sums[i];
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }

        int[] result = new int[3];
        int max = 0;
        for (int i = _k; i <= n - 2 * _k; i++) {
            int left = leftMax[i - 1];
            int right = rightMax[i + _k];
            int total = sums[i + _k] - sums[i] + sums[left + _k] - sums[left] + sums[right + _k] - sums[right];
            if (total > max) {
                max = total;
                result[0] = left;
                result[1] = i;
                result[2] = right;
            }
        }
        return result;
    }

}
