package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1881. Maximum Value after Insertion.
 */
class Problem1881 extends LeetcodeProblem {

    String maxValue(String n, int x) {
        int i = 0;
        if (n.charAt(0) != '-') {
            while (i < n.length() && n.charAt(i) - '0' >= x) {
                i++;
            }
        } else {
            for (i = 1; i < n.length() && n.charAt(i) - '0' <= x;) {
                i++;
            }
        }
        return n.substring(0, i) + x + n.substring(i);
    }

}
