package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

class Problem0942 extends LeetcodeProblem {

    int[] diStringMatch(String _s) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= _s.length(); i++) {
            deque.add(i);
        }
        int[] result = new int[_s.length() + 1];
        for (int i = 0; i <= _s.length(); i++) {
            if (i == _s.length()) {
                result[i] = deque.pollLast();
            } else if (_s.charAt(i) == 'I') {
                result[i] = deque.pollFirst();
            } else {
                result[i] = deque.pollLast();
            }
        }
        return result;
    }

}
