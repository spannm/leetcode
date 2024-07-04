package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1893 extends LeetcodeProblem {

    boolean isCovered(int[][] _ranges, int _left, int _right) {
        Arrays.sort(_ranges, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int checked = _left;
        for (int[] range : _ranges) {
            while (checked >= range[0] && checked <= range[1]) {
                checked++;
            }
        }
        return checked >= _right + 1;
    }

}
