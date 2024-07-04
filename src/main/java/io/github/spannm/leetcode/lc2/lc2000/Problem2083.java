package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2083. Substrings That Begin and End With the Same Letter.
 */
class Problem2083 extends LeetcodeProblem {

    long numberOfSubstrings(String s) {
        int[] cnt = new int[26];
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            cnt[j]++;
            ans += cnt[j];
        }
        return ans;
    }

}
