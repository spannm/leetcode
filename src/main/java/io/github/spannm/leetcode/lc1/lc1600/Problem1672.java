package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1672 extends LeetcodeProblem {

    int maximumWealth(int[][] _accounts) {
        int n = _accounts[0].length;
        int max = 0;
        for (int[] account : _accounts) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += account[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

}
