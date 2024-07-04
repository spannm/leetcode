package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2931. Maximum Spending After Buying Items.
 */
class Problem2931 extends LeetcodeProblem {

    long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < m; i++) {
            pq.offer(new int[] {values[i][n - 1], i, n - 1});
        }
        long ans = 0;
        for (int d = 1; !pq.isEmpty(); d++) {
            var p = pq.poll();
            int v = p[0];
            int i = p[1];
            int j = p[2];
            ans += (long) v * d;
            if (j > 0) {
                pq.offer(new int[] {values[i][j - 1], i, j - 1});
            }
        }
        return ans;
    }

}
