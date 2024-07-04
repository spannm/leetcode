package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1499. Max Value of Equation.
 */
class Problem1499 extends LeetcodeProblem {

    int findMaxValueOfEquation(int[][] points, int k) {
        int ans = -(1 << 30);
        Deque<int[]> q = new ArrayDeque<>();
        for (var p : points) {
            int x = p[0];
            int y = p[1];
            while (!q.isEmpty() && x - q.peekFirst()[0] > k) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                ans = Math.max(ans, x + y + q.peekFirst()[1] - q.peekFirst()[0]);
            }
            while (!q.isEmpty() && y - x >= q.peekLast()[1] - q.peekLast()[0]) {
                q.pollLast();
            }
            q.offerLast(p);
        }
        return ans;
    }

}
