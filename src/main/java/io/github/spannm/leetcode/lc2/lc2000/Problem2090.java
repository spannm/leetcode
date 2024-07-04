package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/k-radius-subarray-averages/">2090. K Radius Subarray Averages</a>.
 */
class Problem2090 extends LeetcodeProblem {

    int[] getAverages(final int[] _nums, final int _k) {
        if (_k == 0) {
            return _nums;
        }

        final int div = _k * 2 + 1;
        final int len = _nums.length;
        final long[] pre = new long[len + 1]; // use long to avoid integer overflow

        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] + _nums[i];
        }

        final int[] out = new int[len];
        Arrays.fill(out, -1);

        for (int i = _k; i < len - _k; i++) {
            out[i] = (int) ((pre[i + _k + 1] - pre[i - _k]) / div);
        }
        return out;
    }

}
