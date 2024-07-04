package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0400 extends LeetcodeProblem {

    int findNthDigit(int _n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (_n > len * count) {
            _n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (_n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((_n - 1) % len));
    }

}
