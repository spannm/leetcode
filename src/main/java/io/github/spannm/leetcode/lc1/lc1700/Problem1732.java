package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/find-the-highest-altitude/">1732. Find the Highest Altitude</a>.
 */
class Problem1732 extends LeetcodeProblem {

    int largestAltitude(final int[] _gain) {
        int alt = 0;
        int max = 0;
        for (int g : _gain) {
            alt += g;
            if (alt > max) {
                max = alt;
            }
        }
        return max;
    }

}
