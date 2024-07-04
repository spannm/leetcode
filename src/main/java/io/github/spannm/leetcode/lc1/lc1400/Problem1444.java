package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/"> 1444. Number of Ways of Cutting a
 * Pizza</a>.
 */
class Problem1444 extends LeetcodeProblem {

    private static final int  MAGIC_NUMBER = 1_000_000_007;
    private static final byte EMPTY        = 0;
    private static final byte APPLE        = 1;

    int ways(final String[] _pizza, final int _nbPeople) {
        final byte nbRows = (byte) _pizza.length;
        final byte nbCols = (byte) _pizza[0].length();

        final byte[][] pizza = Arrays.stream(_pizza).map(row -> {
            byte[] arr = new byte[nbCols];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = row.charAt(i) == 'A' ? APPLE : EMPTY;
            }
            return arr;
        }).toArray(byte[][]::new);

        final Integer[][][] dynProg = new Integer[_nbPeople][nbRows][nbCols];
        final int[][] preSum = new int[nbRows + 1][nbCols + 1];

        for (byte row = (byte) (nbRows - 1); row >= 0; row--) {
            for (int col = nbCols - 1; col >= 0; col--) {
                preSum[row][col] = preSum[row][col + 1] + preSum[row + 1][col] - preSum[row + 1][col + 1] + pizza[row][col];
            }
        }

        return depthFirstSearch(nbRows, nbCols, _nbPeople - 1, 0, 0, dynProg, preSum);
    }

    static int depthFirstSearch(byte _nbRows, byte _nbCols, int _nbCuts, int _row, int _col, Integer[][][] _dynProg, int[][] _preSum) {
        if (_preSum[_row][_col] == 0) {
            return 0;
        } else if (_nbCuts == 0) {
            return 1;
        } else if (_dynProg[_nbCuts][_row][_col] != null) {
            return _dynProg[_nbCuts][_row][_col];
        }

        int ans = 0;

        for (int nr = _row + 1; nr < _nbRows; nr++) {
            if (_preSum[_row][_col] - _preSum[nr][_col] > 0) {
                ans = (ans + depthFirstSearch(_nbRows, _nbCols, _nbCuts - 1, nr, _col, _dynProg, _preSum)) % MAGIC_NUMBER;
            }
        }
        for (int nc = _col + 1; nc < _nbCols; nc++) {
            if (_preSum[_row][_col] - _preSum[_row][nc] > 0) {
                ans = (ans + depthFirstSearch(_nbRows, _nbCols, _nbCuts - 1, _row, nc, _dynProg, _preSum)) % MAGIC_NUMBER;
            }
        }

        return _dynProg[_nbCuts][_row][_col] = ans;
    }

}
