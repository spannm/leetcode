package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1942. The Number of the Smallest Unoccupied Chair.
 */
class Problem1942 extends LeetcodeProblem {

    int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] ts = new int[n][3];
        Queue<Integer> q = new PriorityQueue<>();
        Queue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            ts[i] = new int[] {times[i][0], times[i][1], i};
            q.offer(i);
        }
        Arrays.sort(ts, Comparator.comparingInt(a -> a[0]));
        for (int[] t : ts) {
            int a = t[0];
            int b = t[1];
            int i = t[2];
            while (!busy.isEmpty() && busy.peek()[0] <= a) {
                q.offer(busy.poll()[1]);
            }
            int c = q.poll();
            if (i == targetFriend) {
                return c;
            }
            busy.offer(new int[] {b, c});
        }
        return -1;
    }

}
