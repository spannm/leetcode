package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2712. Minimum Cost to Make All Characters Equal.
 */
class Problem2712 extends LeetcodeProblem {

    long minimumCost(String s) {
        long ans = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += Math.min(i, n - i);
            }
        }
        return ans;
    }

}
