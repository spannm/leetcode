package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/n-queens-ii/">52. N-Queens II</a>.
 */
class Problem0052 extends LeetcodeProblem {

    int totalNQueens(int _n) {
        return totalNQueens(0, new boolean[_n], new boolean[2 * _n], new boolean[2 * _n], _n, 0);
    }

    static int totalNQueens(int _row, boolean[] _cols, boolean[] _diag, boolean[] _antiDiag, int _n, int _count) {
        if (_row == _n) {
            return _count + 1;
        } else {
            for (int col = 0; col < _n; col++) {
                int x = col - _row + _n;
                int y = col + _row;
                if (_cols[col] || _diag[x] || _antiDiag[y]) {
                    continue;
                }
                _cols[col] = true;
                _diag[x] = true;
                _antiDiag[y] = true;
                _count = totalNQueens(_row + 1, _cols, _diag, _antiDiag, _n, _count);
                _cols[col] = false;
                _diag[x] = false;
                _antiDiag[y] = false;
            }
        }
        return _count;
    }

}
