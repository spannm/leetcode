package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1872. Stone Game VIII.
 */
class Problem1872 extends LeetcodeProblem {

    int stoneGameVIII(int[] stones) {
        int n = stones.length;
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }
        int f = stones[n - 1];
        for (int i = n - 2; i > 0; i--) {
            f = Math.max(f, stones[i] - f);
        }
        return f;
    }

}
