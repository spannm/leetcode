package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1262. Greatest Sum Divisible by Three.
 */
class Problem1262 extends LeetcodeProblem {

    int maxSumDivThree(int[] _nums) {
        final int inf = 1 << 30;
        int[] f = new int[] {0, -inf, -inf};
        for (int x : _nums) {
            int[] g = f.clone();
            for (int j = 0; j < 3; j++) {
                g[j] = Math.max(f[j], f[(j - x % 3 + 3) % 3] + x);
            }
            f = g;
        }
        return f[0];
    }

}
