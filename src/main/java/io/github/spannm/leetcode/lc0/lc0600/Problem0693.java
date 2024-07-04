package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0693 extends LeetcodeProblem {

    boolean hasAlternatingBits(int _n) {
        String binaryStr = Integer.toBinaryString(_n);
        for (int i = 1; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i - 1) == binaryStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
