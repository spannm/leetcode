package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1208. Get Equal Substrings Within Budget.
 */
class Problem1208 extends LeetcodeProblem {

    int equalSubstring(String _s, String _t, int _maxCost) {
        int len = _s.length();
        int sum = 0;
        int ans = 0;
        for (int i = 0, j = 0; i < len; i++) {
            sum += Math.abs(_s.charAt(i) - _t.charAt(i));
            while (sum > _maxCost) {
                sum -= Math.abs(_s.charAt(j) - _t.charAt(j));
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}
