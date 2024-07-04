package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0302 extends LeetcodeProblem {

    int minArea(char[][] _image, int _x, int _y) {
        int nbRows = _image.length;
        int nbCols = _image[0].length;
        int left = searchColumns(0, _y, 0, nbRows, true, _image);
        int right = searchColumns(_y + 1, nbCols, 0, nbRows, false, _image);
        int top = searchRows(0, _x, left, right, true, _image);
        int bottom = searchRows(_x + 1, nbRows, left, right, false, _image);
        return (right - left) * (bottom - top);
    }

    static int searchColumns(int _i1, int _i2, int _top, int _bottom, boolean _opt, char[][] _image) {
        while (_i1 != _i2) {
            int k = _top;
            int mid = (_i1 + _i2) / 2;
            while (k < _bottom && _image[k][mid] == '0') {
                k++;
            }
            if (k < _bottom == _opt) {
                _i2 = mid;
            } else {
                _i1 = mid + 1;
            }
        }
        return _i1;
    }

    static int searchRows(int _i1, int _i2, int _left, int _right, boolean _opt, char[][] _image) {
        while (_i1 != _i2) {
            int k = _left;
            int mid = (_i1 + _i2) / 2;
            while (k < _right && _image[mid][k] == '0') {
                k++;
            }
            if (k < _right == _opt) {
                _i2 = mid;
            } else {
                _i1 = mid + 1;
            }
        }
        return _i1;
    }

}
