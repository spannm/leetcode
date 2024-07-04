package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1526 extends LeetcodeProblem {

    int minNumberOperations(int[] _target) {
        int ops = 0;
        while (!allZero(_target)) {
            int i = 0;
            while (_target[i] == 0) {
                i++;
            }
            for (; i < _target.length && _target[i] != 0; i++) {
                _target[i]--;
            }
            ops++;
        }
        return ops;
    }

    private boolean allZero(int[] _target) {
        for (int i : _target) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
