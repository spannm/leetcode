package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2403. Minimum Time to Kill All Monsters.
 */
class Problem2403 extends LeetcodeProblem {

    private int    len;
    private long[] f;
    private int[]  power;

    long minimumTime(int[] _power) {
        power = _power;
        len = _power.length;
        f = new long[1 << len];
        Arrays.fill(f, -1);
        return dfs(0);
    }

    long dfs(int mask) {
        if (f[mask] != -1) {
            return f[mask];
        }
        int cnt = Integer.bitCount(mask);
        if (cnt == len) {
            return 0;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if ((mask >> i & 1) == 1) {
                continue;
            }
            ans = Math.min(ans, dfs(mask | 1 << i) + (power[i] + cnt) / (cnt + 1));
        }
        f[mask] = ans;
        return ans;
    }

}
