package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-queens/">51. N-Queens</a>.
 */
class Problem0051 extends LeetcodeProblem {

    List<List<String>> solveNQueens(int _n) {
        List<List<String>> solution = _n <= 0 ? List.of() : search(_n, new ArrayList<>(), new ArrayList<>());
        System.gc();
        return solution;
    }

    static List<List<String>> search(int _n, List<Integer> _col, List<List<String>> _result) {
        if (_col.size() == _n) {
            _result.add(drawBoard(_col));
        } else {
            for (int i = 0; i < _n; i++) {
                if (!isValid(_col, i)) {
                    continue;
                }
                _col.add(i);
                search(_n, _col, _result);
                _col.remove(_col.size() - 1);
            }
        }
        return _result;
    }

    static boolean isValid(List<Integer> _col, int _next) {
        final int row = _col.size();
        for (int i = 0; i < row; i++) {
            if (_next == _col.get(i)
                || i - row == _col.get(i) - _next
                || i - row == _next - _col.get(i)) {
                return false;
            }
        }
        return true;
    }

    static List<String> drawBoard(List<Integer> _cols) {
        final List<String> board = new ArrayList<>();

        for (int i = 0; i < _cols.size(); i++) {
            StringBuilder row = new StringBuilder();
            for (Integer col : _cols) {
                row.append(col == i ? 'Q' : '.');
            }
            board.add(row.toString());
        }
        return board;
    }

}
