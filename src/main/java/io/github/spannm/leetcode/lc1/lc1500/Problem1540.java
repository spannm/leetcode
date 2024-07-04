package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1540. Can Convert String in K Moves.
 */
class Problem1540 extends LeetcodeProblem {

    boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int x = (t.charAt(i) - s.charAt(i) + 26) % 26;
            cnt[x]++;
        }
        for (int i = 1; i < 26; i++) {
            if (i + 26 * (cnt[i] - 1) > k) {
                return false;
            }
        }
        return true;
    }

}
