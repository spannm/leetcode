package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1542. Find Longest Awesome Substring.
 */
class Problem1542 extends LeetcodeProblem {

    int longestAwesome(String s) {
        int[] d = new int[1024];
        int st = 0;
        int ans = 1;
        Arrays.fill(d, -1);
        d[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            int v = s.charAt(i - 1) - '0';
            st ^= 1 << v;
            if (d[st] >= 0) {
                ans = Math.max(ans, i - d[st]);
            } else {
                d[st] = i;
            }
            for (v = 0; v < 10; v++) {
                if (d[st ^ 1 << v] >= 0) {
                    ans = Math.max(ans, i - d[st ^ 1 << v]);
                }
            }
        }
        return ans;
    }

}
