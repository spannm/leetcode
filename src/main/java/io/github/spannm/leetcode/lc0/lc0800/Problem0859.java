package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/buddy-strings/">859. Buddy Strings</a>.
 */
class Problem0859 extends LeetcodeProblem {

    boolean buddyStrings(String _s1, String _s2) {
        final int len1 = _s1.length();
        final int len2 = _s2.length();

        if (len1 != len2) {
            return false;
        }

        if (_s1.equals(_s2)) {
            final int[] freq = new int[26];
            for (char ch : _s1.toCharArray()) {
                freq[ch - 'a']++;
                if (freq[ch - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }

        int c1 = -1;
        int c2 = -1;
        for (int i = 0; i < len1; i++) {
            if (_s1.charAt(i) != _s2.charAt(i)) {
                if (c1 == -1) {
                    c1 = i;
                } else if (c2 == -1) {
                    c2 = i;
                } else {
                    return false;
                }
            }
        }

        if (c2 == -1) {
            return false;
        }

        return _s1.charAt(c1) == _s2.charAt(c2) && _s1.charAt(c2) == _s2.charAt(c1);
    }

}
