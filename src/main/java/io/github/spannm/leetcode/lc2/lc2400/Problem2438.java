package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2438. Range Product Queries of Powers.
 */
class Problem2438 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int[] productQueries(int n, int[][] queries) {
        int[] powers = new int[Integer.bitCount(n)];
        for (int i = 0; n > 0; i++) {
            int x = n & -n;
            powers[i] = x;
            n -= x;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            long x = 1;
            int l = queries[i][0];
            long r = queries[i][1];
            for (int j = l; j <= r; j++) {
                x = x * powers[j] % MOD;
            }
            ans[i] = (int) x;
        }
        return ans;
    }

}
