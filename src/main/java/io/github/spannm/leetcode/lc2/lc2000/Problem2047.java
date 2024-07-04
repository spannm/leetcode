package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2047 extends LeetcodeProblem {

    int countValidWords(String _sentence) {
        String[] tokens = _sentence.split("\\s+");
        int count = 0;
        for (String token : tokens) {
            int hyphenCount = 0;
            int punctuationMarkCount = 0;
            boolean valid = true;
            if (token.isEmpty()) {
                continue;
            }
            for (int i = 0; i < token.length(); i++) {
                if (token.charAt(i) == '-') {
                    hyphenCount++;
                    if (hyphenCount > 1 || i == 0 || i == token.length() - 1 || !Character.isAlphabetic(token.charAt(i - 1)) || !Character.isAlphabetic(token.charAt(i + 1))) {
                        valid = false;
                        break;
                    }
                } else if (token.charAt(i) == '!' || token.charAt(i) == '.' || token.charAt(i) == ',') {
                    punctuationMarkCount++;
                    if (punctuationMarkCount > 1 || i != token.length() - 1) {
                        valid = false;
                        break;
                    }
                } else if (Character.isDigit(token.charAt(i))) {
                    valid = false;
                    break;
                } else if (Character.isDigit(token.charAt(i))) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count++;
            }
        }
        return count;
    }

}
