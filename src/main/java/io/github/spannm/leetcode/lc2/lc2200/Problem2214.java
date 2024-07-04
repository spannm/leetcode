package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2214. Minimum Health to Beat Game.
 */
class Problem2214 extends LeetcodeProblem {

    long minimumHealth(int[] damage, int armor) {
        long s = 0;
        int mx = damage[0];
        for (int v : damage) {
            s += v;
            mx = Math.max(mx, v);
        }
        return s - Math.min(mx, armor) + 1;
    }

}
