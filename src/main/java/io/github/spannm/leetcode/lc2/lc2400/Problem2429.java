package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2429. Minimize XOR.
 */
class Problem2429 extends LeetcodeProblem {

    int minimizeXor(int num1, int num2) {
        int cnt1 = Integer.bitCount(num1);
        int cnt2 = Integer.bitCount(num2);
        for (; cnt1 > cnt2; --cnt1) {
            num1 &= num1 - 1;
        }
        for (; cnt1 < cnt2; ++cnt1) {
            num1 |= num1 + 1;
        }
        return num1;
    }

}
