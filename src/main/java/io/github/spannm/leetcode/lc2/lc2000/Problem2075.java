package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2075 extends LeetcodeProblem {

    String decodeCiphertext(String _encodedText, int _rows) {
        if (_rows == 1) {
            return _encodedText;
        }
        int total = _encodedText.length();
        int cols = total / _rows;
        char[][] grid = new char[_rows][cols];
        int index = 0;
        for (int i = 0; i < _rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = _encodedText.charAt(index++);
            }
        }
        StringBuilder sb = new StringBuilder();
        int colIndex = 0;
        while (colIndex < cols) {
            for (int j = colIndex, i = 0; j < cols && i < _rows; j++, i++) {
                sb.append(grid[i][j]);
            }
            colIndex++;
        }
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == ' ') {
            i--;
        }
        return sb.substring(0, i + 1);
    }

}
