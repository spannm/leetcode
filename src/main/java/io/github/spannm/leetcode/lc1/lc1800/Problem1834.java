package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1834. Single-Threaded CPU.
 */
class Problem1834 extends LeetcodeProblem {

    int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] ts = new int[n][3];
        for (int i = 0; i < n; i++) {
            ts[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(ts, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[n];
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int i = 0;
        int t = 0;
        int k = 0;
        while (!q.isEmpty() || i < n) {
            if (q.isEmpty()) {
                t = Math.max(t, ts[i][0]);
            }
            while (i < n && ts[i][0] <= t) {
                q.offer(new int[] {ts[i][1], ts[i][2]});
                i++;
            }
            var p = q.poll();
            ans[k++] = p[1];
            t += p[0];
        }
        return ans;
    }

}
