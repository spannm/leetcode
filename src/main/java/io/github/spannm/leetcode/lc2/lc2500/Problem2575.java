package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2575. Find the Divisibility Array of a String.
 */
class Problem2575 extends LeetcodeProblem {

    int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        long x = 0;
        for (int i = 0; i < n; i++) {
            x = (x * 10 + word.charAt(i) - '0') % m;
            if (x == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

}
