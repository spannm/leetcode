package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1888. Minimum Number of Flips to Make the Binary String Alternating.
 */
class Problem1888 extends LeetcodeProblem {

    int minFlips(String s) {
        int n = s.length();
        String target = "01";
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != target.charAt(i & 1)) {
                cnt++;
            }
        }
        int ans = Math.min(cnt, n - cnt);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != target.charAt(i & 1)) {
                cnt--;
            }
            if (s.charAt(i) != target.charAt(i + n & 1)) {
                cnt++;
            }
            ans = Math.min(ans, Math.min(cnt, n - cnt));
        }
        return ans;
    }

}
