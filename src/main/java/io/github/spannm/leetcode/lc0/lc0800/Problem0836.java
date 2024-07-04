package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0836 extends LeetcodeProblem {

    boolean isRectangleOverlap(int[] _rec1, int[] _rec2) {
        return _rec1[0] < _rec2[2] && _rec2[0] < _rec1[2] && _rec1[1] < _rec2[3] && _rec2[1] < _rec1[3];
    }

}
