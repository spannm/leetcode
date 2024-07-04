package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0264 extends LeetcodeProblem {

    int nthUglyNumber(int _n) {
        int[] ugly = new int[_n];
        ugly[0] = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        int fact2 = 2;
        int fact3 = 3;
        int fact5 = 5;
        for (int i = 1; i < _n; i++) {
            int min = Math.min(Math.min(fact2, fact3), fact5);
            ugly[i] = min;
            if (fact2 == min) {
                fact2 = 2 * ugly[++idx2];
            }
            if (fact3 == min) {
                fact3 = 3 * ugly[++idx3];
            }
            if (fact5 == min) {
                fact5 = 5 * ugly[++idx5];
            }
        }
        return ugly[_n - 1];
    }

}
