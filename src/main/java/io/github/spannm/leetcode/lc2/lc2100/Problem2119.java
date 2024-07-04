package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2119 extends LeetcodeProblem {

    boolean isSameAfterReversals(int _num) {
        return _num == 0 || _num % 10 != 0;
    }

}
