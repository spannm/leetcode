package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0223 extends LeetcodeProblem {

    int computeArea(int _ax1, int _ay1, int _ax2, int _ay2,
        int _bx1, int _by1, int _bx2, int _by2) {
        int areaA = (_ax2 - _ax1) * (_ay2 - _ay1);
        int areaB = (_bx2 - _bx1) * (_by2 - _by1);

        int top = Math.min(_ay2, _by2);
        int bottom = Math.max(_ay1, _by1);
        int left = Math.max(_ax1, _bx1);
        int right = Math.min(_ax2, _bx2);

        int overlap = 0;
        if (top > bottom && right > left) {
            overlap = (top - bottom) * (right - left);
        }
        return areaA + areaB - overlap;
    }

}
