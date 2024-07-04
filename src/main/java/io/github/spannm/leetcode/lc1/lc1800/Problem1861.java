package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1861 extends LeetcodeProblem {

    char[][] rotateTheBox(char[][] _box) {
        int m = _box.length;
        int n = _box[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (_box[i][j] == '#') {
                    int empty = j + 1;
                    while (empty < n && _box[i][empty] == '.') {
                        empty++;
                    }
                    if (empty < n && _box[i][empty] == '.') {
                        _box[i][empty] = '#';
                        _box[i][j] = '.';
                    } else if (empty - 1 < n && _box[i][empty - 1] == '.') {
                        _box[i][empty - 1] = '#';
                        _box[i][j] = '.';
                    }

                }
            }
        }
        char[][] result = new char[n][m];
        int k = m - 1;
        for (char[] chars : _box) {
            for (int j = 0; j < n; j++) {
                result[j][k] = chars[j];
            }
            k--;
        }
        return result;
    }

}
