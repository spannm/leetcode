package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1611 extends LeetcodeProblem {

    int minimumOneBitOperations(int _n) {
        int res = 0;
        for (int tmp = _n; tmp != 0; tmp /= 2) {
            res ^= tmp;
        }
        return res;
    }

}
