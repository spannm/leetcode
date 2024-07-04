package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0286 extends LeetcodeProblem {

    private static final int[] DIRS = new int[] {0, 1, 0, -1, 0};

    void wallsAndGates(int[][] _rooms) {
        if (_rooms == null || _rooms.length == 0 || _rooms[0].length == 0) {
            return;
        }
        int nbRows = _rooms.length;
        int nbCols = _rooms[0].length;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_rooms[r][c] == 0) {
                    bfs(_rooms, r, c, nbRows, nbCols);
                }
            }
        }
    }

    static void bfs(int[][] _rooms, int _r, int _c, int _nbRows, int _nbCols) {
        for (int k = 0; k < 4; k++) {
            int x = DIRS[k] + _r;
            int y = DIRS[k + 1] + _c;
            if (x >= 0 && y >= 0 && x < _nbRows && y < _nbCols && _rooms[x][y] > _rooms[_r][_c] + 1) {
                _rooms[x][y] = _rooms[_r][_c] + 1;
                bfs(_rooms, x, y, _nbRows, _nbCols);
            }
        }
    }

}
