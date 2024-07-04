package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/shortest-path-to-get-all-keys/description/">864. Shortest Path to Get All
 * Keys</a>.
 */
class Problem0864 extends LeetcodeProblem {

    static final char START = '@';
    static final char WALL  = '#';

    static int shortestPathAllKeys(final String[] _grid) {

        final int rowCount = _grid.length;
        final int colCount = _grid[0].length();

        final Map<Character, Integer> keyBitMap = new HashMap<>();
        int bitStart = 0;

        for (String s : _grid) {
            for (int j = 0; j < colCount; j++) {
                if (Character.isLowerCase(s.charAt(j))) {
                    keyBitMap.put(s.charAt(j), bitStart++);
                }
            }
        }

        int maskEnd = (1 << bitStart) - 1;
        int maskSize = 1 << bitStart;

        boolean[][][] memo = new boolean[rowCount][colCount][maskSize];

        int[] start = new int[3];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (_grid[i].charAt(j) == START) { // starting point
                    start = new int[] {i, j, 0};
                }
            }
        }

        final Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int k = 0; k < sz; k++) {
                final int[] curr = q.poll();
                final int row = curr[0];
                final int col = curr[1];
                int mask = curr[2];

                if (row < 0 || row >= rowCount || col < 0 || col >= colCount) {
                    continue;
                } else if (_grid[row].charAt(col) == WALL) {
                    continue;
                } else if (Character.isUpperCase(_grid[row].charAt(col))
                    && (mask & 1 << keyBitMap.get(Character.toLowerCase(_grid[row].charAt(col)))) == 0) {
                    continue;
                }

                if (Character.isLowerCase(_grid[row].charAt(col))) {
                    mask |= 1 << keyBitMap.get(_grid[row].charAt(col));
                }

                if (mask == maskEnd) {
                    return step;
                } else if (memo[row][col][mask]) {
                    continue;
                }

                memo[row][col][mask] = true;

                q.addAll(List.of(
                    new int[] {row + 1, col, mask},
                    new int[] {row - 1, col, mask},
                    new int[] {row, col + 1, mask},
                    new int[] {row, col - 1, mask}));
            }
            step++;
        }
        return -1;
    }

}
