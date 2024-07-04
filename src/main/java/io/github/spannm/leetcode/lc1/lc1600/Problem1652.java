package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1652 extends LeetcodeProblem {

    int[] decrypt(int[] _code, int _k) {
        int[] result = new int[_code.length];
        int len = _code.length;
        if (_k == 0) {
            for (int i = 0; i < _code.length; i++) {
                result[i] = 0;
            }
        } else if (_k > 0) {
            int kSum = 0;
            for (int i = 1; i <= _k; i++) {
                kSum += _code[i];
            }
            result[0] = kSum;
            for (int i = 1; i < len; i++) {
                kSum -= _code[i];
                kSum += _code[(i + _k) % len];
                result[i] = kSum;
            }
        } else {
            int kSum = 0;
            int kVal = Math.abs(_k);
            for (int i = len - 1; i >= len - kVal; i--) {
                kSum += _code[i];
            }
            result[0] = kSum;
            for (int i = 1; i < len; i++) {
                kSum -= _code[(len - kVal + i - 1) % len];
                kSum += _code[i - 1];
                result[i] = kSum;
            }
        }
        return result;
    }

}
