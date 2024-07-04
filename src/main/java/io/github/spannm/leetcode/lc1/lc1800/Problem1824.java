package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1824. Minimum Sideway Jumps.
 */
class Problem1824 extends LeetcodeProblem {

    int minSideJumps(int[] obstacles) {
        final int inf = 1 << 30;
        int[] f = {1, 0, 1};
        for (int i = 1; i < obstacles.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) {
                    f[j] = inf;
                    break;
                }
            }
            int x = Math.min(f[0], Math.min(f[1], f[2])) + 1;
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] != j + 1) {
                    f[j] = Math.min(f[j], x);
                }
            }
        }
        return Math.min(f[0], Math.min(f[1], f[2]));
    }

}
