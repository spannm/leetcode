package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2511. Maximum Enemy Forts That Can Be Captured.
 */
class Problem2511 extends LeetcodeProblem {

    int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            if (forts[i] != 0) {
                while (j < n && forts[j] == 0) {
                    j++;
                }
                if (j < n && forts[i] + forts[j] == 0) {
                    ans = Math.max(ans, j - i - 1);
                }
            }
            i = j;
        }
        return ans;
    }

}
