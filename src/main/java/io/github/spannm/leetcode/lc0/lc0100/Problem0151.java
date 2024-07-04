package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/">151. Reverse Words in a String</a>.
 */
class Problem0151 extends LeetcodeProblem {

    String reverseWords(String _s) {
        if (_s == null || _s.isBlank()) {
            return "";
        }
        String[] words = _s.trim().split(" ");
        if (words.length == 0) {
            return "";
        }
        Deque<String> stack = new ArrayDeque<>();
        for (String word : words) {
            if (!"".equals(word)) {
                stack.offer(word);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast())
                .append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
