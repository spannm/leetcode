package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2543. Check if Point Is Reachable.
 */
class Problem2543 extends LeetcodeProblem {

    boolean isReachable(int targetX, int targetY) {
        int x = gcd(targetX, targetY);
        return (x & x - 1) == 0;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
