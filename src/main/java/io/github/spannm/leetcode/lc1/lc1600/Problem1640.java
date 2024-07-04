package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1640 extends LeetcodeProblem {

    boolean canFormArray(int[] _arr, int[][] _pieces) {
        for (int[] piece : _pieces) {
            int first = piece[0];
            int index = findIndex(_arr, first);
            if (index == -1) {
                return false;
            }
            int i = 0;
            for (int j = index; i < piece.length && j < _arr.length; i++, j++) {
                if (_arr[j] != piece[i]) {
                    return false;
                }
            }
            if (i != piece.length) {
                return false;
            }
        }
        return true;
    }

    private int findIndex(int[] _arr, int _key) {
        for (int i = 0; i < _arr.length; i++) {
            if (_arr[i] == _key) {
                return i;
            }
        }
        return -1;
    }

}
