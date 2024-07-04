package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0562 extends LeetcodeProblem {

    int longestLine(int[][] _m) {
        if (_m == null || _m.length == 0) {
            return 0;
        }
        int[][] directions = new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int longestLine = 0;
        int nbRows = _m.length;
        int nbCols = _m[0].length;
        int[][][] cache = new int[nbRows][nbCols][8];
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_m[r][c] == 1) {
                    for (int k = 0; k < directions.length; k++) {
                        int nextR = r + directions[k][0];
                        int nextC = c + directions[k][1];
                        int thisLine = 1;
                        if (nextR >= 0 && nextR < nbRows && nextC >= 0 && nextC < nbCols && cache[nextR][nextC][k] != 0) {
                            thisLine += cache[nextR][nextC][k];
                            cache[r][c][k] = thisLine;
                        } else {
                            while (nextR >= 0 && nextR < nbRows && nextC >= 0 && nextC < nbCols && _m[nextR][nextC] == 1) {
                                thisLine++;
                                cache[r][c][k] = thisLine;
                                nextR += directions[k][0];
                                nextC += directions[k][1];
                            }
                        }
                        longestLine = Math.max(longestLine, thisLine);
                    }
                }
            }
        }
        return longestLine;
    }

}
