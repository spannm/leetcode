package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2864. Maximum Odd Binary Number.
 */
class Problem2864 extends LeetcodeProblem {

    String maximumOddBinaryNumber(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            }
        }
        return "1".repeat(cnt - 1) + "0".repeat(s.length() - cnt) + "1";
    }

}
