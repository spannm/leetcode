package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/house-robber/">198. House Robber</a>.
 */
class Problem0198 extends LeetcodeProblem {

    int rob(int[] _money) {
        final int nbHouses = _money.length;
        if (nbHouses == 1) {
            return _money[0];
        }

        int[] proceeds = new int[nbHouses + 1];
        proceeds[0] = 0;
        proceeds[1] = _money[0];

        for (int i = 1; i < nbHouses; i++) {
            proceeds[i + 1] = Math.max(proceeds[i], proceeds[i - 1] + _money[i]);
        }
        return proceeds[nbHouses];
    }

}
