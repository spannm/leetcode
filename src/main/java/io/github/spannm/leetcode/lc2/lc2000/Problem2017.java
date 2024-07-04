package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2017 extends LeetcodeProblem {

    long gridGame(int[][] _grid) {
        int n = _grid[0].length;
        long[] cum0 = new long[n + 1];
        long[] cum1 = new long[n + 1];
        for (int i = 0; i < n; i++) {
            cum0[i + 1] = cum0[i] + _grid[0][i];
            cum1[i + 1] = cum1[i] + _grid[1][i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(cum0[n] - cum0[i + 1], cum1[i]));
        }
        return ans;
    }

}
