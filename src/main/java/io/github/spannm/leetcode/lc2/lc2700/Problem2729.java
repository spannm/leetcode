package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2729. Check if The Number is Fascinating.
 */
class Problem2729 extends LeetcodeProblem {

    boolean isFascinating(int n) {
        String s = "" + n + 2 * n + 3 * n;
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            if (++cnt[c - '0'] > 1) {
                return false;
            }
        }
        return cnt[0] == 0 && s.length() == 9;
    }

}
