package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0755 extends LeetcodeProblem {

    int[] pourWater(int[] _heights, int _v, int _k) {
        int index;
        while (_v > 0) {
            index = _k;
            for (int i = _k - 1; i >= 0; i--) {
                if (_heights[i] > _heights[index]) {
                    break;
                } else if (_heights[i] < _heights[index]) {
                    index = i;
                }
            }
            if (index != _k) {
                _heights[index]++;
                _v--;
                continue;
            }

            for (int i = _k + 1; i < _heights.length; i++) {
                if (_heights[i] > _heights[index]) {
                    break;
                } else if (_heights[i] < _heights[index]) {
                    index = i;
                }
            }
            _heights[index]++;
            _v--;
        }
        return _heights;
    }

}
