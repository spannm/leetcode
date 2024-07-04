package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2839. Check if Strings Can be Made Equal With Operations I.
 */
class Problem2839 extends LeetcodeProblem {

    boolean canBeEqual(String s1, String s2) {
        int[][] cnt = new int[2][26];
        for (int i = 0; i < s1.length(); i++) {
            ++cnt[i & 1][s1.charAt(i) - 'a'];
            --cnt[i & 1][s2.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[0][i] != 0 || cnt[1][i] != 0) {
                return false;
            }
        }
        return true;
    }

}
