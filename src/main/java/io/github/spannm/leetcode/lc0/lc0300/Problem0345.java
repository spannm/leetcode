package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">345. Reverse Vowels of a String</a>.
 */
class Problem0345 extends LeetcodeProblem {

    String reverseVowels(String _s) {
        final int len = _s.length();
        if (len < 2) {
            return _s;
        }
        int ri = len - 1; // index from right
        final char[] chars = _s.toCharArray();
        for (int li = 0; li < ri; li++) {
            char leftChar = chars[li];
            if (isVowel(leftChar)) {
                while (ri > li) {
                    char rightChar = chars[ri];
                    if (isVowel(rightChar)) {
                        if (rightChar != leftChar) {
                            // perform swap
                            chars[li] = rightChar;
                            chars[ri] = leftChar;
                        }
                        ri--;
                        break;
                    }
                    ri--;
                }
            }
        }
        return new String(chars);
    }

    static boolean isVowel(char _c) {
        return _c == 'a' || _c == 'e' || _c == 'i' || _c == 'o' || _c == 'u'
            || _c == 'A' || _c == 'E' || _c == 'I' || _c == 'O' || _c == 'U';
    }

}
