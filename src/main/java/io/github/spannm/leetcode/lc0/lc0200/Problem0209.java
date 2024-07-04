package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">209. Minimum Size Subarray Sum</a>.
 */
class Problem0209 extends LeetcodeProblem {

    static int minSubArrayLen(final int _target, final int[] _nums) {
        final int len = _nums.length;
        int res = len + 1;
        int sum = 0;
        int st = 0;

        for (int i = 0; i < len; i++) {
            sum += _nums[i];
            while (sum >= _target && st <= i) {
                res = Math.min(res, i - st + 1);
                sum -= _nums[st++];
            }
        }

        if (res == len + 1) {
            res = 0;
        }
        return res;
    }

}
