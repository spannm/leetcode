package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1619 extends LeetcodeProblem {

    double trimMean(int[] _arr) {
        Arrays.sort(_arr);
        int n = _arr.length;
        long sum = 0;
        for (int i = (int) Math.round(n * 0.05); i < n - n * 0.05; i++) {
            sum += _arr[i];
        }
        return sum / (n - n * 0.1);
    }

}
