package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2509. Cycle Length Queries in a Tree.
 */
class Problem2509 extends LeetcodeProblem {

    int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int t = 1;
            while (a != b) {
                if (a > b) {
                    a >>= 1;
                } else {
                    b >>= 1;
                }
                t++;
            }
            ans[i] = t;
        }
        return ans;
    }

}
