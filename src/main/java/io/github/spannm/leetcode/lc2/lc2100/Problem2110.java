package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2110 extends LeetcodeProblem {

    long getDescentPeriods(int[] _prices) {
        long ans = _prices.length;
        for (int i = 0; i < _prices.length; i++) {
            long startI = i;
            while (i + 1 < _prices.length && _prices[i] - 1 == _prices[i + 1]) {
                i++;
            }
            long totalNum = i - startI + 1;
            if (totalNum > 1) {
                ans += (totalNum - 1) * totalNum / 2;
            }
        }
        return ans;
    }

}
