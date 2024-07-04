package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/remove-duplicate-letters/">316. Remove Duplicate Letters</a>.
 */
class Problem0316 extends LeetcodeProblem {

    String removeDuplicateLetters(String _s) {
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
            : _s.charAt(pos) + removeDuplicateLetters(
                _s.substring(pos + 1).replaceAll("" + _s.charAt(pos), ""));
    }

}
