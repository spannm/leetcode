package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/shortest-bridge/">934. Shortest Bridge</a>.
 */
class Problem0934 extends LeetcodeProblem {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int shortestBridge(int[][] _grid) {
        final int len = _grid.length;

        for (int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                if (_grid[x][y] == 1) {
                    return findBridge(_grid, len, findIsland(_grid, x, y, len, new HashSet<>()));
                }
            }
        }
        return 0;
    }

    static Set<List<Integer>> findIsland(int[][] _grid, int _r, int _c, int _len, Set<List<Integer>> _islands) {
        if (!isOutOfBounds(_r, _c, _len) && _grid[_r][_c] != 0 && _islands.add(List.of(_r, _c))) {
            for (int[] direction : DIRECTIONS) {
                findIsland(_grid, _r + direction[0], _c + direction[1], _len, _islands);
            }
        }
        return _islands;
    }

    static boolean isOutOfBounds(int _r, int _c, int _len) {
        return _r == -1 || _r == _len || _c == -1 || _c == _len;
    }

    static int findBridge(int[][] _grid, int _len, Set<List<Integer>> _islands) {
        int bridge = 0;

        for (Deque<List<Integer>> q = new ArrayDeque<>(_islands); !q.isEmpty(); bridge++) {
            for (int i = q.size(); i > 0; i--) {
                List<Integer> cell = q.poll();

                for (int[] dir : DIRECTIONS) {
                    int r = cell.get(0) + dir[0];
                    int c = cell.get(1) + dir[1];

                    if (isOutOfBounds(r, c, _len)) {
                        continue;
                    }
                    List<Integer> next = List.of(r, c);
                    if (!_islands.add(next)) {
                        continue;
                    }
                    if (_grid[r][c] == 1) { // island-2 found
                        return bridge;
                    }
                    q.add(next);
                }
            }
        }
        return bridge;
    }

}
