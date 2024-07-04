package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0408 extends LeetcodeProblem {

    boolean validWordAbbreviation(String _word, String _abbr) {
        if (_abbr.length() > _word.length()) {
            return false;
        } else {
            char[] abbrChars = _abbr.toCharArray();
            char[] wordChars = _word.toCharArray();
            if (_abbr.length() == _word.length()) {
                boolean prevDigit = false;
                for (int i = 0, j = 0; i < abbrChars.length && j < wordChars.length; i++, j++) {
                    if (Character.isDigit(abbrChars[i]) && !prevDigit) {
                        prevDigit = true;
                        if (Character.getNumericValue(abbrChars[i]) != 1) {
                            return false;
                        }
                    } else if (Character.isDigit(abbrChars[i]) && prevDigit) {
                        return false;
                    } else if (abbrChars[i] != wordChars[j]) {
                        return false;
                    } else if (prevDigit) {
                        prevDigit = false;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                boolean firstDigit = true;
                for (int i = 0, j = 0; i < abbrChars.length && j < wordChars.length; i++) {
                    while (i < abbrChars.length && Character.isDigit(abbrChars[i])) {
                        if (firstDigit && Character.getNumericValue(abbrChars[i]) == 0) {
                            return false;
                        }
                        sb.append(abbrChars[i]);
                        i++;
                        firstDigit = false;
                    }
                    firstDigit = true;
                    if (!sb.toString().isEmpty()) {
                        int number = Integer.parseInt(sb.toString());
                        j += number;
                        sb.setLength(0);
                    }
                    if (i >= abbrChars.length && j < wordChars.length || i < abbrChars.length && j >= wordChars.length) {
                        return false;
                    } else if (i < abbrChars.length
                        && j < wordChars.length
                        && abbrChars[i] != wordChars[j]) {
                        return false;
                    } else if (j > wordChars.length && i <= abbrChars.length) {
                        return false;
                    }
                    j++;
                }
            }
            return true;
        }
    }

}
