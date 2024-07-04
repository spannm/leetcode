package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2741. Special Permutations.
 */
class Problem2741 extends LeetcodeProblem {

    int specialPerm(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int n = nums.length;
        int m = 1 << n;
        int[][] f = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    int ii = i ^ 1 << j;
                    if (ii == 0) {
                        f[i][j] = 1;
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0) {
                            f[i][j] = (f[i][j] + f[ii][k]) % mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int x : f[m - 1]) {
            ans = (ans + x) % mod;
        }
        return ans;
    }

}
