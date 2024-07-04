package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0279 extends LeetcodeProblem {

    int numSquares(int _n) {
        int result = _n;
        int num = 2;
        while (num * num <= _n) {
            int temp1 = _n / (num * num);
            int temp2 = _n % (num * num);
            result = Math.min(result, temp1 + numSquares(temp2));
            num++;
        }
        return result;
    }

}
