package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/">1503. Last Moment Before All
 * Ants Fall Out of a Plank</a>.
 */
class Problem1503 extends LeetcodeProblem {

    int getLastMoment(int _n, int[] _left, int[] _right) {
        return Math.max(
            Arrays.stream(_left).max().orElse(0),
            Arrays.stream(_right).map(r -> _n - r).max().orElse(0));
    }

}
