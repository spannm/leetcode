package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1310. XOR Queries of a Subarray.
 */
class Problem1310 extends LeetcodeProblem {

    int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] ^ arr[i - 1];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = s[r + 1] ^ s[l];
        }
        return ans;
    }

}
