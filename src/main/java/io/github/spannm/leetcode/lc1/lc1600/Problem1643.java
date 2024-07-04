package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1643. Kth Smallest Instructions.
 */
class Problem1643 extends LeetcodeProblem {

    String kthSmallestPath(int[] destination, int k) {
        int v = destination[0];
        int h = destination[1];
        int n = v + h;
        int[][] c = new int[n + 1][h + 1];
        c[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= h; j++) {
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = n; i > 0; i--) {
            if (h == 0) {
                ans.append('V');
            } else {
                int x = c[v + h - 1][h - 1];
                if (k > x) {
                    ans.append('V');
                    k -= x;
                    v--;
                } else {
                    ans.append('H');
                    h--;
                }
            }
        }
        return ans.toString();
    }

}
