package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0598 extends LeetcodeProblem {

    int maxCount(int _m, int _n, int[][] _ops) {
        return Arrays.stream(_ops).mapToInt(op -> op[0]).min().orElse(_m)
             * Arrays.stream(_ops).mapToInt(op -> op[1]).min().orElse(_n);
    }

}
