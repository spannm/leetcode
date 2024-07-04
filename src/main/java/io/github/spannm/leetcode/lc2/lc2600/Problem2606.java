package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2606. Find the Substring With Maximum Cost.
 */
class Problem2606 extends LeetcodeProblem {

    int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] d = new int[26];
        for (int i = 0; i < d.length; i++) {
            d[i] = i + 1;
        }
        int m = chars.length();
        for (int i = 0; i < m; i++) {
            d[chars.charAt(i) - 'a'] = vals[i];
        }
        int ans = 0;
        int f = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int v = d[s.charAt(i) - 'a'];
            f = Math.max(f, 0) + v;
            ans = Math.max(ans, f);
        }
        return ans;
    }

}
