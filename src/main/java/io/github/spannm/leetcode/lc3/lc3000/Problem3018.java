package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3018. Maximum Number of Removal Queries That Can Be Processed I.
 */
class Problem3018 extends LeetcodeProblem {

    int maximumProcessableQueries(int[] _nums, int[] _queries) {
        int len = _nums.length;
        int[][] f = new int[len][len];
        int m = _queries.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= i; j--) {
                if (i > 0) {
                    f[i][j] = Math.max(
                        f[i][j], f[i - 1][j] + (_nums[i - 1] >= _queries[f[i - 1][j]] ? 1 : 0));
                }
                if (j + 1 < len) {
                    f[i][j] = Math.max(
                        f[i][j], f[i][j + 1] + (_nums[j + 1] >= _queries[f[i][j + 1]] ? 1 : 0));
                }
                if (f[i][j] == m) {
                    return m;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, f[i][i] + (_nums[i] >= _queries[f[i][i]] ? 1 : 0));
        }
        return ans;
    }

}
