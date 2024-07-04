package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0765 extends LeetcodeProblem {

    int minSwapsCouples(int[] _row) {
        int swaps = 0;
        for (int i = 0; i < _row.length - 1; i += 2) {
            int coupleValue = _row[i] % 2 == 0 ? _row[i] + 1 : _row[i] - 1;
            if (_row[i + 1] != coupleValue) {
                swaps++;
                int coupleIndex = findIndex(_row, coupleValue);
                swap(_row, coupleIndex, i + 1);
            }
        }
        return swaps;
    }

    private void swap(int[] _row, int _i, int _j) {
        int tmp = _row[_i];
        _row[_i] = _row[_j];
        _row[_j] = tmp;
    }

    private int findIndex(int[] _row, int _value) {
        for (int i = 0; i < _row.length; i++) {
            if (_row[i] == _value) {
                return i;
            }
        }
        return -1;
    }

}
