package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1156. Swap For Longest Repeated Character Substring.
 */
class Problem1156 extends LeetcodeProblem {

    int maxRepOpt1(String _text) {
        int[] cnt = new int[26];
        int n = _text.length();
        for (int i = 0; i < n; i++) {
            ++cnt[_text.charAt(i) - 'a'];
        }
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && _text.charAt(j) == _text.charAt(i)) {
                j++;
            }
            int l = j - i;
            int k = j + 1;
            while (k < n && _text.charAt(k) == _text.charAt(i)) {
                k++;
            }
            int r = k - j - 1;
            ans = Math.max(ans, Math.min(l + r + 1, cnt[_text.charAt(i) - 'a']));
            i = j;
        }
        return ans;
    }

}
