package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0342 extends LeetcodeProblem {

    boolean isPowerOfFour(int _num) {
        return _num > 0 && 1073741824 % _num == 0 && (_num & 0x55555555) != 0;
    }

}
