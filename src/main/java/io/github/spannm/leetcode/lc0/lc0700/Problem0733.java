package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/flood-fill/">733. Flood Fill</a>.
 */
class Problem0733 extends LeetcodeProblem {

    int[][] floodFill(int[][] _image, int _row, int _col, int _newColor) {
        if (_image[_row][_col] == _newColor) {
            return _image; // nothing to do
        }

        int oldColor = _image[_row][_col]; // color at starting pixel

        fill(_image, _row, _col, oldColor, _newColor);

        return _image;
    }

    static void fill(int[][] _image, int _row, int _col, int _oldColor, int _newColor) {
        if (_row < 0 || _row >= _image.length
            || _col < 0 || _col >= _image[0].length
            || _image[_row][_col] != _oldColor) {
            return;
        }

        _image[_row][_col] = _newColor;
        fill(_image, _row + 1, _col, _oldColor, _newColor);
        fill(_image, _row - 1, _col, _oldColor, _newColor);
        fill(_image, _row, _col + 1, _oldColor, _newColor);
        fill(_image, _row, _col - 1, _oldColor, _newColor);
    }

}
