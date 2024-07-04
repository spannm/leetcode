package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1006. Clumsy Factorial.
 */
class Problem1006 extends LeetcodeProblem {

    int clumsy(int _n) {
        Deque<Integer> s = new ArrayDeque<>();
        s.offerLast(_n);
        int op = 0;
        for (int i = _n - 1; i > 0; i--) {
            if (op == 0) {
                s.offerLast(s.pollLast() * i);
            } else if (op == 1) {
                s.offerLast(s.pollLast() / i);
            } else if (op == 2) {
                s.offerLast(i);
            } else {
                s.offerLast(-i);
            }
            op = (op + 1) % 4;
        }
        int res = 0;
        while (!s.isEmpty()) {
            res += s.pollLast();
        }
        return res;
    }

}
