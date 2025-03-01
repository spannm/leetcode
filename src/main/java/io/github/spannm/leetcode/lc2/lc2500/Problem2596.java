package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2596 extends LeetcodeProblem {

    boolean checkValidGrid(int[][] _grid) {
        int n = _grid.length;
        int[][] offsets = new int[][] {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };
        int x = 0;
        int y = 0;
        int currentVal = 0;
        while (currentVal != n * n - 1) {
            boolean foundNext = false;
            for (int[] offset : offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && _grid[newX][newY] == currentVal + 1) {
                    currentVal++;
                    x = newX;
                    y = newY;
                    foundNext = true;
                    break;
                }
            }
            if (!foundNext) {
                return false;
            }
        }
        return true;
    }

}
