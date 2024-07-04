package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/solving-questions-with-brainpower/">2140. Solving Questions With
 * Brainpower</a>.
 */
class Problem2140 extends LeetcodeProblem {

    long mostPoints(int[][] _questions) {
        final int len = _questions.length;
        final long[] pointsAt = new long[len + 1];

        for (int qd = len - 1; qd >= 0; qd--) {
            int fut = _questions[qd][1] + qd + 1;

            if (fut > len - 1) {
                pointsAt[qd] = _questions[qd][0];
            } else {
                pointsAt[qd] = _questions[qd][0] + pointsAt[fut];
            }

            pointsAt[qd] = Math.max(pointsAt[qd], pointsAt[qd + 1]);
        }
        return pointsAt[0];
    }

}
