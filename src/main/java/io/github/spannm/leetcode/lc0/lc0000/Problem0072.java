package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/edit-distance/">72. Edit Distance</a>.
 */
class Problem0072 extends LeetcodeProblem {

    int minDistance(String _word1, String _word2) {
        final int len1 = _word1.length();
        final int len2 = _word2.length();

        if (len1 == len2 && _word1.equals(_word2)) {
            return 0;
        }

        final int[][] arr = new int[len1 + 1][len2 + 1];

        // Initialize first column and row
        for (int c = 1; c <= len1; c++) {
            arr[c][0] = c;
        }
        for (int r = 1; r <= len2; r++) {
            arr[0][r] = r;
        }

        int insertion;
        int deletion;
        int replacement;
        for (int i1 = 1; i1 <= len1; i1++) {
            for (int i2 = 1; i2 <= len2; i2++) {
                if (_word1.charAt(i1 - 1) == _word2.charAt(i2 - 1)) {
                    arr[i1][i2] = arr[i1 - 1][i2 - 1];
                } else {
                    insertion = arr[i1][i2 - 1];
                    deletion = arr[i1 - 1][i2];
                    replacement = arr[i1 - 1][i2 - 1];

                    arr[i1][i2] = 1 + findMin(insertion, deletion, replacement);
                }
            }
        }

        return arr[len1][len2];
    }

    int findMin(int _x, int _y, int _z) {
        if (_x <= _y && _x <= _z) {
            return _x;
        } else if (_y <= _x && _y <= _z) {
            return _y;
        } else {
            return _z;
        }
    }

}
