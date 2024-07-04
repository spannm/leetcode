package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1927. Sum Game.
 */
class Problem1927 extends LeetcodeProblem {

    boolean sumGame(String num) {
        int n = num.length();
        int cnt1 = 0;
        int cnt2 = 0;
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                cnt1++;
            } else {
                s1 += num.charAt(i) - '0';
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                cnt2++;
            } else {
                s2 += num.charAt(i) - '0';
            }
        }
        return (cnt1 + cnt2) % 2 == 1 || s1 - s2 != 9 * (cnt2 - cnt1) / 2;
    }

}
