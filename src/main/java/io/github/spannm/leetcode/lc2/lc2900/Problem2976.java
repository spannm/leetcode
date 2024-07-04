package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2976. Minimum Cost to Convert String I.
 */
class Problem2976 extends LeetcodeProblem {

    long minimumCost(String _source, String _target, char[] _orig, char[] _changed, int[] _cost) {
        final int inf = 1 << 29;
        int[][] g = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }
        for (int i = 0; i < _orig.length; i++) {
            int x = _orig[i] - 'a';
            int y = _changed[i] - 'a';
            int z = _cost[i];
            g[x][y] = Math.min(g[x][y], z);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        long ans = 0;
        int n = _source.length();
        for (int i = 0; i < n; i++) {
            int x = _source.charAt(i) - 'a';
            int y = _target.charAt(i) - 'a';
            if (x != y) {
                if (g[x][y] >= inf) {
                    return -1;
                }
                ans += g[x][y];
            }
        }
        return ans;
    }

}
