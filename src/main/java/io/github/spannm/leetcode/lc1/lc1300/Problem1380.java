package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1380 extends LeetcodeProblem {

    List<Integer> luckyNumbers(int[][] _matrix) {
        List<Integer> result = new ArrayList<>();
        for (int[] element : _matrix) {
            for (int j = 0; j < _matrix[0].length; j++) {
                if (luckyInRow(element[j], element)) {
                    if (luckyInColumn(element[j], _matrix, j)) {
                        result.add(element[j]);
                    }
                }
            }
        }
        return result;
    }

    private boolean luckyInColumn(int _number, int[][] _matrix, int _columnIndex) {
        for (int[] element : _matrix) {
            if (_number < element[_columnIndex]) {
                return false;
            }
        }
        return true;
    }

    private boolean luckyInRow(int _number, int[] _row) {
        for (int num : _row) {
            if (_number > num) {
                return false;
            }
        }
        return true;
    }

}
