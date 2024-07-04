package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem0296 extends LeetcodeProblem {

    int minTotalDistance(int[][] _grid) {
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_grid[r][c] == 1) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }
        int rowMedian = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int colMedian = cols.get(cols.size() / 2);
        return minDistance1D(rows, rowMedian) + minDistance1D(cols, colMedian);
    }

    static int minDistance1D(List<Integer> _points, int _median) {
        int distance = 0;
        for (int p : _points) {
            distance += Math.abs(p - _median);
        }
        return distance;
    }

}
