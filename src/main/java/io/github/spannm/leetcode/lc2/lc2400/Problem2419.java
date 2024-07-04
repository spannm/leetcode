package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2419. Longest Subarray With Maximum Bitwise AND.
 */
class Problem2419 extends LeetcodeProblem {

    int longestSubarray(int[] nums) {
        int mx = 0;
        for (int v : nums) {
            mx = Math.max(mx, v);
        }
        int ans = 0;
        int cnt = 0;
        for (int v : nums) {
            if (v == mx) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 0;
            }
        }
        return ans;
    }

}
