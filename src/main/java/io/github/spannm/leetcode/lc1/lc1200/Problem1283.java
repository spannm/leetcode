package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1283 extends LeetcodeProblem {

    int smallestDivisor(int[] _nums, int _threshold) {

        int start = 1;
        int result = 0;
        int end = Integer.MAX_VALUE;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (isSumLessThanThreshold(middle, _nums, _threshold)) {
                result = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return result;
    }

    static boolean isSumLessThanThreshold(int _middle, int[] _nums, int _threshold) {
        int sum = 0;
        for (int num : _nums) {
            if (num % _middle == 0) {
                sum += num / _middle;
            } else {
                sum += num / _middle + 1;
            }
        }
        return sum <= _threshold;
    }

}
