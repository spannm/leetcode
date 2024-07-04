package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1653. Minimum Deletions to Make String Balanced.
 */
class Problem1653 extends LeetcodeProblem {

    int minimumDeletions(String s) {
        int n = s.length();
        int ans = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                b++;
            } else {
                ans = Math.min(ans + 1, b);
            }
        }
        return ans;
    }

}
