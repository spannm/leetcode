package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1551 extends LeetcodeProblem {

    int minOperations(int _n) {
        int min = 1;
        int max = 2 * (_n - 1) + 1;
        int equalNumber = (max + min) / 2;
        int ops = 0;
        for (int i = 0; i < _n / 2; i++) {
            ops += equalNumber - (2 * i + 1);
        }
        return ops;
    }

}
