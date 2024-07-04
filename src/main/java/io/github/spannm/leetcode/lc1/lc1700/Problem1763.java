package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1763 extends LeetcodeProblem {

    String longestNiceSubstring(String _s) {
        String longest = "";
        for (int i = 0; i < _s.length() - 1; i++) {
            for (int j = i; j <= _s.length(); j++) {
                if (isNiceString(_s.substring(i, j))) {
                    if (longest.length() < j - i) {
                        longest = _s.substring(i, j);
                    }
                }
            }
        }
        return longest;
    }

    private static boolean isNiceString(String _str) {
        int[] uppercount = new int[26];
        int[] lowercount = new int[26];
        for (char c : _str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercount[Character.toLowerCase(c) - 'a']++;
            } else {
                lowercount[c - 'a']++;
            }
        }
        for (int i = 0; i < uppercount.length; i++) {
            if (uppercount[i] > 0 && lowercount[i] > 0 || uppercount[i] == 0 && lowercount[i] == 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
