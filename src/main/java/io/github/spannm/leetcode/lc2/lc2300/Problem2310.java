package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2310. Sum of Numbers With Units Digit K.
 */
class Problem2310 extends LeetcodeProblem {

    int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        for (int i = 1; i <= num; i++) {
            int t = num - k * i;
            if (t >= 0 && t % 10 == 0) {
                return i;
            }
        }
        return -1;
    }

}
