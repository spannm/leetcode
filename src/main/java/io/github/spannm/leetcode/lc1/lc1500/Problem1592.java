package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1592 extends LeetcodeProblem {

    String reorderSpaces(String _text) {
        int spaceCount = 0;
        for (char c : _text.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        String[] words = _text.trim().split("\\s+");
        if (words.length == 1) {
            return words[0] + " ".repeat(Math.max(0, spaceCount));
        }
        int trailingSpaces = spaceCount % (words.length - 1);
        int newSpaces = spaceCount / (words.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < words.length; j++) {
            sb.append(words[j]);
            if (j < words.length - 1) {
                sb.append(" ".repeat(Math.max(0, newSpaces)));
            } else {
                sb.append(" ".repeat(Math.max(0, trailingSpaces)));
            }
        }
        return sb.toString();
    }

}
