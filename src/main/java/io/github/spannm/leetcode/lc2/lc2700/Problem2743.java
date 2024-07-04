package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2743. Count Substrings Without Repeating Character.
 */
class Problem2743 extends LeetcodeProblem {

    int numberOfSpecialSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int[] cnt = new int[26];
        for (int i = 0, j = 0; i < n; i++) {
            int k = s.charAt(i) - 'a';
            cnt[k]++;
            while (cnt[k] > 1) {
                --cnt[s.charAt(j++) - 'a'];
            }
            ans += i - j + 1;
        }
        return ans;
    }

}
