package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Random;

/**
 * 497. Random Point in Non-overlapping Rectangles.
 */
class Problem0497 extends LeetcodeProblem {

    static class Solution {
        private final int[][] rects;
        private final int     len;
        private final int[]   s;
        private final Random  random = new Random();

        Solution(int[][] _rects) {
            rects = _rects;
            len = _rects.length;
            s = new int[len + 1];
            for (int i = 0; i < len; i++) {
                s[i + 1] = s[i] + (_rects[i][2] - _rects[i][0] + 1) * (_rects[i][3] - _rects[i][1] + 1);
            }
        }

        int[] pick() {
            int v = 1 + random.nextInt(s[len]);
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = left + right >> 1;
                if (s[mid] >= v) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int[] rect = rects[left - 1];
            return new int[] {rect[0] + random.nextInt(rect[2] - rect[0] + 1), rect[1] + random.nextInt(rect[3] - rect[1] + 1)};
        }
    }

}
