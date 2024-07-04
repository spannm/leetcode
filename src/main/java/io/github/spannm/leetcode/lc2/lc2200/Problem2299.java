package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Set;

class Problem2299 extends LeetcodeProblem {

    boolean strongPasswordCheckerII(String _password) {
        int len = _password.length();
        if (len < 8) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        Set<Character> specialChars = Set.of('!', '@', '%', '^', '&', '*', '(', ')', '-', '+', '$', '#');
        for (int i = 0; i < len; i++) {
            char c = _password.charAt(i);
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.contains(c)) {
                hasSpecialChar = true;
            }
            if (i > 0 && c == _password.charAt(i - 1)) {
                return false;
            }
        }
        return hasLower && hasUpper && hasDigit && hasSpecialChar;
    }

}
