package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2770. Maximum Number of Jumps to Reach the Last Index.
 */
class Problem2770 extends LeetcodeProblem {

    private int[]     nums;
    private int       len;
    private int       target;
    private Integer[] f;

    int maximumJumps(int[] _nums, int _target) {
        nums = _nums;
        len = _nums.length;
        target = _target;
        f = new Integer[len];
        int ans = dfs(0);
        return ans < 0 ? -1 : ans;
    }

    int dfs(int i) {
        if (i == len - 1) {
            return 0;
        } else if (f[i] != null) {
            return f[i];
        }
        int ans = -(1 << 30);
        for (int j = i + 1; j < len; j++) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                ans = Math.max(ans, 1 + dfs(j));
            }
        }
        return f[i] = ans;
    }

}
