package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0661 extends LeetcodeProblem {

    int[][] imageSmoother(int[][] _img) {
        if (_img == null || _img.length == 0) {
            return _img;
        }

        int nbRows = _img.length;
        int nbCols = _img[0].length;
        int[][] result = new int[nbRows][nbCols];

        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                int sum = _img[r][c];
                int denominator = 1;
                if (c + 1 < nbCols) {
                    sum += _img[r][c + 1];
                    denominator++;
                    if (r + 1 < nbRows) {
                        sum += _img[r + 1][c + 1];
                        denominator++;
                    }
                }
                if (c - 1 >= 0) {
                    sum += _img[r][c - 1];
                    denominator++;
                    if (r + 1 < nbRows) {
                        sum += _img[r + 1][c - 1];
                        denominator++;
                    }
                }
                if (r - 1 >= 0) {
                    sum += _img[r - 1][c];
                    denominator++;
                    if (c - 1 >= 0) {
                        sum += _img[r - 1][c - 1];
                        denominator++;
                    }
                    if (c + 1 < nbCols) {
                        sum += _img[r - 1][c + 1];
                        denominator++;
                    }
                }
                if (r + 1 < nbRows) {
                    sum += _img[r + 1][c];
                    denominator++;
                }
                result[r][c] = sum / denominator;
            }
        }

        return result;
    }

}
