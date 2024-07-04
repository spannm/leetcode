package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

class Problem0604 extends LeetcodeProblem {

    static class StringIterator {

        private final Deque<int[]> deque;

        StringIterator(String _compressed) {
            deque = new ArrayDeque<>();
            int len = _compressed.length();
            int i = 0;
            while (i < len) {
                int j = i + 1;
                while (j < len && Character.isDigit(_compressed.charAt(j))) {
                    j++;
                }
                deque.addLast(new int[] {_compressed.charAt(i) - 'A', Integer.parseInt(_compressed.substring(i + 1, j))});
                i = j;
            }
        }

        char next() {
            if (deque.isEmpty()) {
                return ' ';
            }
            int[] top = deque.peek();
            top[1]--;
            if (top[1] == 0) {
                deque.pollFirst();
            }
            return (char) ('A' + top[0]);
        }

        boolean hasNext() {
            return !deque.isEmpty();
        }
    }

}
