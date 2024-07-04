package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1566 extends LeetcodeProblem {

    boolean containsPattern(int[] _arr, int _m, int _k) {
        final int len = _arr.length;
        for (int i = 0; i < len - _m; i++) {
            int[] pattern = Arrays.copyOfRange(_arr, i, i + _m);
            int times = 1;
            for (int j = i + _m; j < len; j += _m) {
                int[] candidate = Arrays.copyOfRange(_arr, j, j + _m);
                if (Arrays.equals(pattern, candidate)) {
                    times++;
                    if (times == _k) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

}
