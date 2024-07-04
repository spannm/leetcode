package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1252 extends LeetcodeProblem {

    int oddCells(int _n, int _m, int[][] _indices) {
        int[][] matrix = new int[_n][_m];
        for (int[] index : _indices) {
            addOneToRow(matrix, index[0]);
            addOneToColumn(matrix, index[1]);
        }
        int oddNumberCount = 0;
        for (int[] element : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (element[j] % 2 != 0) {
                    oddNumberCount++;
                }
            }
        }
        return oddNumberCount;
    }

    private void addOneToColumn(int[][] _matrix, int _columnIndex) {
        for (int i = 0; i < _matrix.length; i++) {
            _matrix[i][_columnIndex] += 1;
        }
    }

    private void addOneToRow(int[][] _matrix, int _rowIndex) {
        for (int j = 0; j < _matrix[0].length; j++) {
            _matrix[_rowIndex][j] += 1;
        }
    }

}
