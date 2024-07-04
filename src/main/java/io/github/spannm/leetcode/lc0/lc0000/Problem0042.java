package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">42. Trapping Rain Water</a>.
 */
class Problem0042 extends LeetcodeProblem {

    int trap(int[] _heights) {
        int len = _heights.length;
        if (len <= 2) {
            return 0;
        }

        int max = _heights[0];
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            if (_heights[i] > max) {
                max = _heights[i];
                maxIndex = i;
            }
        }

        int water = 0;

        int leftMax = _heights[0];
        for (int i = 0; i < maxIndex; i++) {
            if (_heights[i] > leftMax) {
                leftMax = _heights[i];
            } else {
                water += leftMax - _heights[i];
            }
        }

        int rightMax = _heights[len - 1];
        for (int i = len - 1; i > maxIndex; i--) {
            if (_heights[i] > rightMax) {
                rightMax = _heights[i];
            } else {
                water += rightMax - _heights[i];
            }
        }

        return water;
    }

}
