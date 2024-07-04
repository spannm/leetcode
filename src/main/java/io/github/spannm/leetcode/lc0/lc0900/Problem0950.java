package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Problem0950 extends LeetcodeProblem {

    int[] deckRevealedIncreasing(int[] _deck) {
        Arrays.sort(_deck);
        Deque<Integer> deque = new ArrayDeque<>();
        int len = _deck.length;
        for (int i = len - 1; i >= 0; i--) {
            if (i != len - 1) {
                deque.addFirst(deque.pollLast());
            }
            deque.addFirst(_deck[i]);
        }
        int[] result = new int[len];
        int i = 0;
        while (!deque.isEmpty()) {
            result[i++] = deque.pollFirst();
        }
        return result;
    }

}
