package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2177 extends LeetcodeProblem {

    long[] sumOfThree(long _num) {
        long remainder = _num % 3;
        long ave = _num / 3;
        if (remainder == 0) {
            return new long[] {ave - 1, ave, ave + 1};
        } else {
            return new long[] {};
        }
    }

}
