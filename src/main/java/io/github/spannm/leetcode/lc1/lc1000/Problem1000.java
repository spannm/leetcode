package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-merge-stones/">1000. Minimum Cost to Merge Stones</a>.
 */
class Problem1000 extends LeetcodeProblem {

    int mergeStones(int[] _stones, int _k) {
        int len = _stones.length;
        if ((len - 1) % (_k - 1) != 0) {
            return -1;
        }
        int[] s = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            s[i] = s[i - 1] + _stones[i - 1];
        }
        int[][][] f = new int[len + 1][len + 1][_k + 1];
        final int inf = 1 << 20;
        for (int[][] g : f) {
            for (int[] e : g) {
                Arrays.fill(e, inf);
            }
        }
        for (int i = 1; i <= len; i++) {
            f[i][i][1] = 0;
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 1; i + l - 1 <= len; i++) {
                int j = i + l - 1;
                for (int k = 1; k <= _k; k++) {
                    for (int h = i; h < j; h++) {
                        f[i][j][k] = Math.min(f[i][j][k], f[i][h][1] + f[h + 1][j][k - 1]);
                    }
                }
                f[i][j][1] = f[i][j][_k] + s[j] - s[i - 1];
            }
        }
        return f[1][len][1];
    }

}
