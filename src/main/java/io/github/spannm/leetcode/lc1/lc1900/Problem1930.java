package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1930 extends LeetcodeProblem {

    int countPalindromicSubsequence(String _s) {
        int[] first = new int[26];
        int[] last = new int[26];
        int res = 0;
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < _s.length(); i++) {
            int x = _s.charAt(i) - 'a';
            first[x] = Math.min(first[x], i);
            last[x] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                res += _s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        }
        return res;
    }

}
