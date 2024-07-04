package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 996. Number of Squareful Arrays.
 */
class Problem0996 extends LeetcodeProblem {

    int numSquarefulPerms(int[] _nums) {
        int len = _nums.length;
        int[][] f = new int[1 << len][len];
        for (int j = 0; j < len; j++) {
            f[1 << j][j] = 1;
        }
        for (int i = 0; i < 1 << len; i++) {
            for (int j = 0; j < len; j++) {
                if ((i >> j & 1) == 1) {
                    for (int k = 0; k < len; k++) {
                        if ((i >> k & 1) == 1 && k != j) {
                            int s = _nums[j] + _nums[k];
                            int t = (int) Math.sqrt(s);
                            if (t * t == s) {
                                f[i][j] += f[i ^ 1 << j][k];
                            }
                        }
                    }
                }
            }
        }
        long ans = 0;
        for (int j = 0; j < len; j++) {
            ans += f[(1 << len) - 1][j];
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : _nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int[] g = new int[13];
        g[0] = 1;
        for (int i = 1; i < 13; i++) {
            g[i] = g[i - 1] * i;
        }
        for (int v : cnt.values()) {
            ans /= g[v];
        }
        return (int) ans;
    }

}
