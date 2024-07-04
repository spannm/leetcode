package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">11. Container with most water</a>.
 */
class Problem0011 extends LeetcodeProblem {

    int maxArea(final int[] _height) {
        int idxL = 0;
        int idxR = _height.length - 1;
        int hL = 0;
        int hR = 0;
        int area = 0;
        int maxArea1 = 0;

        while (idxL < idxR) {
            hL = _height[idxL];
            hR = _height[idxR];
            area = Math.min(hL, hR) * (idxR - idxL);
            if (area > maxArea1) {
                maxArea1 = area;
            }

            if (hL < hR) {
                while (idxL < idxR && _height[idxL] <= hL) {
                    idxL++;
                }
            } else {
                while (idxL < idxR && _height[idxR] <= hR) {
                    idxR--;
                }
            }
        }
        return maxArea1;
    }

}
