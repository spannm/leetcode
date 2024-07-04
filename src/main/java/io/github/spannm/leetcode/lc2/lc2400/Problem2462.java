package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/total-cost-to-hire-k-workers/description/">2462. Total Cost to Hire K
 * Workers</a>.
 */
class Problem2462 extends LeetcodeProblem {

    long totalCost(final int[] _costs, final int _hireCount, final int _n) {
        final int len = _costs.length;

        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < _n; i++) {
            q.offer(new int[] {_costs[i], 0});
        }
        for (int i = Math.max(_n, len - _n); i < len; i++) {
            q.offer(new int[] {_costs[i], 1});
        }

        long totalCost = 0;
        int nextHead = _n;
        int nextTail = len - 1 - _n;

        for (int i = 0; i < _hireCount; i++) {
            int[] curWorker = q.poll();
            int curCost = curWorker[0];
            int curSectionId = curWorker[1];
            totalCost += curCost;

            if (nextHead <= nextTail) {
                if (curSectionId == 0) {
                    q.offer(new int[] {_costs[nextHead], 0});
                    nextHead++;
                } else {
                    q.offer(new int[] {_costs[nextTail], 1});
                    nextTail--;
                }
            }
        }

        return totalCost;
    }

}
