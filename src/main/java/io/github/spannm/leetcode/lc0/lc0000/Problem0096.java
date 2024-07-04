package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0096 extends LeetcodeProblem {

    int numTrees(int _n) {
        int[] g = new int[_n + 1];
        g[0] = g[1] = 1;

        for (int i = 2; i <= _n; i++) {
            for (int j = 1; j <= i; j++) {
                int temp = g[j - 1] * g[i - j];
                g[i] = g[i] + temp;
            }
        }
        return g[_n];
    }

}
