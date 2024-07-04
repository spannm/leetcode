package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0467 extends LeetcodeProblem {

    int findSubstringInWraproundString(String _str) {
        if (_str == null || _str.isEmpty()) {
            return 0;
        } else if (_str.length() < 2) {
            return _str.length();
        }
        int count = 0;
        int[] dp = new int[26];
        dp[_str.charAt(0) - 'a'] = 1;
        int len = 1;
        for (int i = 1; i < _str.length(); i++) {
            if (_str.charAt(i) - 1 == _str.charAt(i - 1) || _str.charAt(i) == 'a' && _str.charAt(i - 1) == 'z') {
                len++;
            } else {
                len = 1;
            }
            dp[_str.charAt(i) - 'a'] = Math.max(len, dp[_str.charAt(i) - 'a']);
        }

        for (int i : dp) {
            count += i;
        }
        return count;
    }

}
