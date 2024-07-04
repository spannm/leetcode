package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2464. Minimum Subarrays in a Valid Split.
 */
class Problem2464 extends LeetcodeProblem {

    private static final int INF = 0x3f3f3f3f;
    private int[]            nums;
    private int              n;
    private int[]            f;

    int validSubarraySplit(int[] _nums) {
        nums = _nums;
        n = _nums.length;
        f = new int[n];
        int ans = dfs(0);
        return ans < INF ? ans : -1;
    }

    private int dfs(int _i) {
        if (_i >= n) {
            return 0;
        }
        if (f[_i] > 0) {
            return f[_i];
        }
        int ans = INF;
        for (int j = _i; j < n; j++) {
            if (gcd(nums[_i], nums[j]) > 1) {
                ans = Math.min(ans, 1 + dfs(j + 1));
            }
        }
        f[_i] = ans;
        return ans;
    }

    private int gcd(int _a, int _b) {
        return _b == 0 ? _a : gcd(_b, _a % _b);
    }

}
