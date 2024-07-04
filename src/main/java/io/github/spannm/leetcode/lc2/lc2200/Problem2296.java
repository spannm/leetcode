package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2296 extends LeetcodeProblem {

    static class TextEditor {
        private final StringBuilder left  = new StringBuilder();
        private final StringBuilder right = new StringBuilder();

        public void addText(String text) {
            left.append(text);
        }

        public int deleteText(int k) {
            k = Math.min(k, left.length());
            left.setLength(left.length() - k);
            return k;
        }

        public String cursorLeft(int k) {
            k = Math.min(k, left.length());
            for (int i = 0; i < k; i++) {
                right.append(left.charAt(left.length() - 1));
                left.deleteCharAt(left.length() - 1);
            }
            return left.substring(Math.max(left.length() - 10, 0));
        }

        public String cursorRight(int k) {
            k = Math.min(k, right.length());
            for (int i = 0; i < k; i++) {
                left.append(right.charAt(right.length() - 1));
                right.deleteCharAt(right.length() - 1);
            }
            return left.substring(Math.max(left.length() - 10, 0));
        }

    }

}
