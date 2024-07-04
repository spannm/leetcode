package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2947. Count Beautiful Substrings I.
 */
class Problem2947 extends LeetcodeProblem {

    int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int[] vs = new int[26];
        for (char c : "aeiou".toCharArray()) {
            vs[c - 'a'] = 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int vowels = 0;
            for (int j = i; j < n; j++) {
                vowels += vs[s.charAt(j) - 'a'];
                int consonants = j - i + 1 - vowels;
                if (vowels == consonants && vowels * consonants % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
