package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/">1081. Smallest Subsequence of
 * Distinct Characters</a>.
 */
class Problem1081 extends LeetcodeProblem {

    String smallestSubsequence(String _s) {
        int[] count = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < _s.length(); i++) {
            count[_s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) < _s.charAt(pos)) {
                pos = i;
            }
            count[_s.charAt(i) - 'a']--;
            if (count[_s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return _s.isEmpty() ? ""
            : _s.charAt(pos) + smallestSubsequence(
                _s.substring(pos + 1).replaceAll("" + _s.charAt(pos), ""));
    }

}
