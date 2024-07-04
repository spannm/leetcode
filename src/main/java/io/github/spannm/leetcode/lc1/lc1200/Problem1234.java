package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1234. Replace the Substring for Balanced String.
 */
class Problem1234 extends LeetcodeProblem {

    int balancedString(String _s) {
        int[] cnt = new int[4];
        String t = "QWER";
        int n = _s.length();
        for (int i = 0; i < n; i++) {
            cnt[t.indexOf(_s.charAt(i))]++;
        }
        int m = n / 4;
        if (cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m) {
            return 0;
        }
        int ans = n;
        for (int i = 0, j = 0; i < n; i++) {
            cnt[t.indexOf(_s.charAt(i))]--;
            while (j <= i && cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m) {
                ans = Math.min(ans, i - j + 1);
                cnt[t.indexOf(_s.charAt(j++))]++;
            }
        }
        return ans;
    }

}
