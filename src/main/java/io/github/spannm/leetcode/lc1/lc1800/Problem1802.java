package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/">1802. Maximum Value at a
 * Given Index in a Bounded Array</a>.
 */
class Problem1802 extends LeetcodeProblem {

    int maxValue(final int _n, final int _index, final int _maxSum) {
        final int maxSum = _maxSum - _n;

        int left = 0;
        int right = maxSum;

        while (left < right) {
            int middle = (left + right + 1) / 2;
            if (test(_n, _index, maxSum, middle)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left + 1;
    }

    private static boolean test(int _n, int _index, int _maxSum, int _val) {
        int leftVal = Math.max(0, _val - _index);
        int rightVal = Math.max(0, _val - (_n - 1 - _index));

        long sumBefore = (long) (_val + leftVal) * (_val - leftVal + 1) / 2;
        long sumAfter = (long) (_val + rightVal) * (_val - rightVal + 1) / 2;

        return sumBefore + sumAfter - _val <= _maxSum;
    }

}
