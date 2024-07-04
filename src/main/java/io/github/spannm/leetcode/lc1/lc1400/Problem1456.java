package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">1456. Maximum Number
 * of Vowels in a Substring of Given Length</a>.
 */
class Problem1456 extends LeetcodeProblem {

    int maxVowels(String _str, int _substrLen) {
        final char[] chars = _str.toCharArray();
        final int len = chars.length;

        int cnt = 0; // vowel count of current substring
        int max = 0; // max vowel count encountered

        for (int i = 0; i < len; i++) {
            if (isVowel(chars[i])) {
                cnt++;
            }
            if (i >= _substrLen) {
                if (isVowel(chars[i - _substrLen])) {
                    cnt--;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    static boolean isVowel(char _c) {
        return _c == 'a' || _c == 'e' || _c == 'i' || _c == 'o' || _c == 'u';
    }

}
