package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2398. Maximum Number of Robots Within Budget.
 */
class Problem2398 extends LeetcodeProblem {

    int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = chargeTimes.length;
        long s = 0;
        int j = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = chargeTimes[i];
            int b = runningCosts[i];
            while (!q.isEmpty() && chargeTimes[q.getLast()] <= a) {
                q.pollLast();
            }
            q.offer(i);
            s += b;
            while (!q.isEmpty() && chargeTimes[q.getFirst()] + (i - j + 1) * s > budget) {
                if (q.getFirst() == j) {
                    q.pollFirst();
                }
                s -= runningCosts[j++];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}
