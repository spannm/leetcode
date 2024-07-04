package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2028 extends LeetcodeProblem {

    int[] missingRolls(int[] _rolls, int _mean, int _n) {
        long sum = 0L;
        for (int num : _rolls) {
            sum += num;
        }
        long totalSum = (long) (_rolls.length + _n) * _mean;
        long remainder = totalSum - sum;
        if (remainder / _n > 6 || remainder / _n == 6 && remainder % _n != 0 || remainder / _n < 0 || remainder < _n) {
            return new int[] {};
        }
        int ave = (int) (remainder / _n);
        int remain = (int) (remainder % _n);
        int[] ans = new int[_n];
        int k = 0;
        while (k < _n) {
            ans[k++] = ave + remain > 0 ? 1 : 0;
            remain--;
        }
        return ans;
    }

}
