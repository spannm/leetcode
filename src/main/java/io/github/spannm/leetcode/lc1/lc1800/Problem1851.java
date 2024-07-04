package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1851. Minimum Interval to Include Each Query.
 */
class Problem1851 extends LeetcodeProblem {

    int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] qs = new int[m][0];
        for (int i = 0; i < m; i++) {
            qs[i] = new int[] {queries[i], i};
        }
        Arrays.sort(qs, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int i = 0;
        for (int[] q : qs) {
            while (i < n && intervals[i][0] <= q[0]) {
                int a = intervals[i][0];
                int b = intervals[i][1];
                pq.offer(new int[] {b - a + 1, b});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < q[0]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans[q[1]] = pq.peek()[0];
            }
        }
        return ans;
    }

}
