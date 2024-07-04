package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0079 extends LeetcodeProblem {

    boolean exist(final char[][] _board, final String _word) {
        int rows = _board.length;
        int cols = _board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (_word.charAt(0) == _board[r][c] && search(_board, _word, r, c, 0, new boolean[rows][cols])) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean search(char[][] _board, String _word, int _r, int _c, int _pos, boolean[][] _visited) {
        if (_pos == _word.length()) {
            return true;
        } else if (_r < 0 || _c < 0 || _r >= _board.length || _c >= _board[0].length || _word.charAt(_pos) != _board[_r][_c] || _visited[_r][_c]) {
            return false;
        }
        _visited[_r][_c] = true;
        if (search(_board, _word, _r + 1, _c, _pos + 1, _visited)
            || search(_board, _word, _r - 1, _c, _pos + 1, _visited)
            || search(_board, _word, _r, _c + 1, _pos + 1, _visited)
            || search(_board, _word, _r, _c - 1, _pos + 1, _visited)) {
            return true;
        }

        _visited[_r][_c] = false;
        return false;
    }

}
