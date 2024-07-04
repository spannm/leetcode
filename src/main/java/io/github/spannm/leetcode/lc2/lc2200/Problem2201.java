package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2201 extends LeetcodeProblem {

    int digArtifacts(int _n, int[][] _artifacts, int[][] _dig) {
        int ans = 0;
        boolean[][] grid = new boolean[_n][_n];
        for (int[] d : _dig) {
            grid[d[0]][d[1]] = true;
        }
        for (int[] arti : _artifacts) {
            int r0 = arti[0];
            int c0 = arti[1];
            boolean cannotUnearth = false;
            for (int r = r0; r <= arti[2]; r++) {
                for (int c = c0; c <= arti[3]; c++) {
                    if (!grid[r][c]) {
                        cannotUnearth = true;
                        break;
                    }
                }
                if (cannotUnearth) {
                    break;
                }
            }
            if (!cannotUnearth) {
                ans++;
            }
        }
        return ans;
    }

}
