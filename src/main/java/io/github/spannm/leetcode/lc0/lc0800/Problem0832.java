package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0832 extends LeetcodeProblem {

    int[][] flipAndInvertImage(int[][] _arr) {
        int nbRows = _arr.length;
        int nbCols = _arr[0].length;
        int[][] result = new int[nbRows][nbCols];
        for (int r = 0; r < nbRows; r++) {
            int[] flipped = reverse(_arr[r]);
            result[r] = invert(flipped);
        }
        return result;
    }

    static int[] invert(int[] _flipped) {
        int[] result = new int[_flipped.length];
        for (int i = 0; i < _flipped.length; i++) {
            if (_flipped[i] == 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    static int[] reverse(int[] _nums) {
        for (int i = 0, j = _nums.length - 1; i < j; i++, j--) {
            int tmp = _nums[i];
            _nums[i] = _nums[j];
            _nums[j] = tmp;
        }
        return _nums;
    }

}
