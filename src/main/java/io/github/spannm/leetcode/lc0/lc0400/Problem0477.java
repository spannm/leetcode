package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0477 extends LeetcodeProblem {

    int totalHammingDistance(int[] _nums) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            int zero = 0;
            int bit = 1 << i;
            for (int n : _nums) {
                if ((n & bit) != 0) {
                    one++;
                } else {
                    zero++;
                }
            }
            r += one * zero;
        }
        return r;
    }

}
