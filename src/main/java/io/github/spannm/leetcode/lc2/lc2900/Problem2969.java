package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2969. Minimum Number of Coins for Fruits II.
 */
class Problem2969 extends LeetcodeProblem {

    int minimumCoins(int[] prices) {
        int n = prices.length;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = n; i > 0; i--) {
            while (!q.isEmpty() && q.peek() > i * 2 + 1) {
                q.poll();
            }
            if (i <= (n - 1) / 2) {
                prices[i - 1] += prices[q.peek() - 1];
            }
            while (!q.isEmpty() && prices[q.peekLast() - 1] >= prices[i - 1]) {
                q.pollLast();
            }
            q.offer(i);
        }
        return prices[0];
    }

}
