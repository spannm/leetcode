package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1177. Can Make Palindrome from Substring.
 */
class Problem1177 extends LeetcodeProblem {

    @SuppressWarnings("PMD.LinguisticNaming")
    List<Boolean> canMakePaliQueries(String _s, int[][] _queries) {
        int len = _s.length();
        int[][] ss = new int[len + 1][26];
        for (int i = 1; i <= len; i++) {
            System.arraycopy(ss[i - 1], 0, ss[i], 0, 26);
            ss[i][_s.charAt(i - 1) - 'a']++;
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] q : _queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int x = 0;
            for (int j = 0; j < 26; j++) {
                x += ss[r + 1][j] - ss[l][j] & 1;
            }
            result.add(x / 2 <= k);
        }
        return result;
    }

}
