package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">567. Permutation in String</a>.
 */
class Problem0567 extends LeetcodeProblem {

    boolean checkInclusion(String _sub, String _container) {
        final int subLen = _sub.length();
        final int clen = _container.length();

        if (subLen > clen) {
            return false;
        }

        int[] s1counts = new int[26];
        int[] s2counts = new int[26];
        for (int i = 0; i < subLen; i++) {
            s1counts[_sub.charAt(i) - 'a']++;
            s2counts[_container.charAt(i) - 'a']++;
        }

        if (matches(s1counts, s2counts)) {
            return true;
        }

        for (int i = subLen; i < clen; i++) {
            s2counts[_container.charAt(i) - 'a']++;
            s2counts[_container.charAt(i - subLen) - 'a']--;
            if (matches(s1counts, s2counts)) {
                return true;
            }
        }
        return matches(s1counts, s2counts);
    }

    static boolean matches(int[] _s1count, int[] _s2count) {
        for (int i = 0; i < 26; i++) {
            if (_s1count[i] != _s2count[i]) {
                return false;
            }
        }
        return true;
    }

}
