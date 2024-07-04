package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2379 extends LeetcodeProblem {

    int minimumRecolors(String _blocks, int _k) {
        int min = _k;
        int left = 0;
        int right = 0;
        int recolors = 0;
        while (right - left < _k) {
            if (_blocks.charAt(right) == 'W') {
                recolors++;
            }
            right++;
        }
        if (right - left == _k) {
            min = Math.min(recolors, min);
        }
        while (right < _blocks.length() && left < _blocks.length() - _k) {
            if (_blocks.charAt(right) == 'W') {
                recolors++;
            }
            right++;
            if (_blocks.charAt(left) == 'W') {
                recolors--;
            }
            left++;
            min = Math.min(recolors, min);
        }
        return min;
    }

}
