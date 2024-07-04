package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0484 extends LeetcodeProblem {

    int[] findPermutation(String _s) {
        int[] result = new int[_s.length() + 1];
        for (int i = 0; i <= _s.length(); i++) {
            result[i] = i + 1;
        }
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == 'D') {
                int left = i;
                while (i < _s.length() && _s.charAt(i) == 'D') {
                    i++;
                }
                reverse(result, left, i);
            }
        }
        return result;
    }

    private static void reverse(int[] _result, int _left, int _i) {
        while (_left < _i) {
            int temp = _result[_left];
            _result[_left] = _result[_i];
            _result[_i] = temp;
            _left++;
            _i--;
        }
    }

}
