package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/">1964. Find the
 * Longest Valid Obstacle Course at Each Position</a>.
 */
class Problem1964 extends LeetcodeProblem {

    static int[] longestObstacleCourseAtEachPosition(final int[] _obstacles) {
        final int nbObstacles = _obstacles.length;

        final int[] incrSubseq = new int[nbObstacles];
        final int[] results = new int[nbObstacles];

        int pos = 0;

        for (int i = 0; i < nbObstacles; i++) {
            int left = 0;
            int right = pos;

            while (left < right) {
                int mid = (left + right) / 2;
                if (incrSubseq[mid] <= _obstacles[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            results[i] = left + 1;
            if (left == pos) {
                pos++;
            }
            incrSubseq[left] = _obstacles[i];
        }
        return results;
    }

}
