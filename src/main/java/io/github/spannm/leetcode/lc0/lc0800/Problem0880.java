package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/decoded-string-at-index/">880. Decoded String at Index</a>.
 */
class Problem0880 extends LeetcodeProblem {

    String decodeAtIndex(String _s, int _k) {
        final int len = _s.length();
        long decodedSz = 0;

        // Calculate the total size of the decoded string
        for (char c : _s.toCharArray()) {
            if (Character.isDigit(c)) {
                decodedSz *= c - '0';
            } else {
                decodedSz++;
            }
        }

        // traverse string in reverse to find kth letter
        for (int i = len - 1; i >= 0; i--) {
            char currentChar = _s.charAt(i);
            _k %= decodedSz;

            // if k becomes 0 and the current character is a letter, return it
            if (_k == 0 && Character.isLetter(currentChar)) {
                return Character.toString(currentChar);
            }

            // adjust the decoded size based on the current character
            if (Character.isDigit(currentChar)) {
                decodedSz /= currentChar - '0';
            } else {
                decodedSz--;
            }
        }

        return "";
    }

}
