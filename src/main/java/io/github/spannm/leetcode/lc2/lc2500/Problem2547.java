package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2547. Minimum Cost to Split an Array.
 */
class Problem2547 extends LeetcodeProblem {

    private int[]     nums;
    private int       n;
    private int       k;
    private Integer[] f;

    int minCost(int[] _nums, int _k) {
        nums = _nums;
        n = _nums.length;
        k = _k;
        f = new Integer[n];
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int[] cnt = new int[n];
        int one = 0;
        int ans = 1 << 30;
        for (int j = i; j < n; j++) {
            int x = ++cnt[nums[j]];
            if (x == 1) {
                one++;
            } else if (x == 2) {
                one--;
            }
            ans = Math.min(ans, k + j - i + 1 - one + dfs(j + 1));
        }
        return f[i] = ans;
    }

}
