package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0461 extends LeetcodeProblem {

    int hammingDistance(int _x, int _y) {
        int n = _x ^ _y;
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

}
