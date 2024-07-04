package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 711. Number of Distinct Islands II.
 */
class Problem0711 extends LeetcodeProblem {

    private int[][] grid;
    private int     nbRows;
    private int     nbCols;

    int numDistinctIslands2(int[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        Set<List<List<Integer>>> s = new HashSet<>();
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (_grid[i][j] == 1) {
                    List<Integer> shape = new ArrayList<>();
                    dfs(i, j, shape);
                    s.add(normalize(shape));
                }
            }
        }
        return s.size();
    }

    private List<List<Integer>> normalize(List<Integer> _shape) {
        @SuppressWarnings("unchecked")
        List<int[]>[] shapes = new List[8];
        for (int i = 0; i < 8; i++) {
            shapes[i] = new ArrayList<>();
        }
        for (int e : _shape) {
            int i = e / nbCols;
            int j = e % nbCols;
            shapes[0].add(new int[] {i, j});
            shapes[1].add(new int[] {i, -j});
            shapes[2].add(new int[] {-i, j});
            shapes[3].add(new int[] {-i, -j});
            shapes[4].add(new int[] {j, i});
            shapes[5].add(new int[] {j, -i});
            shapes[6].add(new int[] {-j, i});
            shapes[7].add(new int[] {-j, -i});
        }
        for (List<int[]> e : shapes) {
            e.sort((a, b) -> {
                int i1 = a[0];
                int j1 = a[1];
                int i2 = b[0];
                int j2 = b[1];
                if (i1 == i2) {
                    return j1 - j2;
                }
                return i1 - i2;
            });
            int a = e.get(0)[0];
            int b = e.get(0)[1];
            for (int k = e.size() - 1; k >= 0; k--) {
                int i = e.get(k)[0];
                int j = e.get(k)[1];
                e.set(k, new int[] {i - a, j - b});
            }
        }
        Arrays.sort(shapes, (a, b) -> {
            for (int k = 0; k < a.size(); k++) {
                int i1 = a.get(k)[0];
                int j1 = a.get(k)[1];
                int i2 = b.get(k)[0];
                int j2 = b.get(k)[1];
                if (i1 != i2) {
                    return i1 - i2;
                }
                if (j1 != j2) {
                    return j1 - j2;
                }
            }
            return 0;
        });
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] e : shapes[0]) {
            ans.add(Arrays.asList(e[0], e[1]));
        }
        return ans;
    }

    private void dfs(int _i, int _j, List<Integer> _shape) {
        _shape.add(_i * nbCols + _j);
        grid[_i][_j] = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = _i + dirs[k];
            int y = _j + dirs[k + 1];
            if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && grid[x][y] == 1) {
                dfs(x, y, _shape);
            }
        }
    }

}
