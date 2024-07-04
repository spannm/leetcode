package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0476 extends LeetcodeProblem {

    int findComplement(int _num) {
        return ~_num & (Integer.highestOneBit(_num) << 1) - 1;
    }

}
