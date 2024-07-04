package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2402. Meeting Rooms III.
 */
class Problem2402 extends LeetcodeProblem {

    int mostBooked(int _n, int[][] _meetings) {
        Arrays.sort(_meetings, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Queue<Integer> idle = IntStream.range(0, _n).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        final int[] cnt = new int[_n];
        for (int[] v : _meetings) {
            int s = v[0];
            int e = v[1];
            while (!busy.isEmpty() && busy.peek()[0] <= s) {
                idle.offer(busy.poll()[1]);
            }
            int i = 0;
            if (idle.isEmpty()) {
                int[] x = busy.poll();
                i = x[1];
                busy.offer(new int[] {x[0] + e - s, i});
            } else {
                i = idle.poll();
                busy.offer(new int[] {e, i});
            }
            cnt[i]++;
        }
        int ans = 0;
        for (int i = 0; i < _n; i++) {
            if (cnt[ans] < cnt[i]) {
                ans = i;
            }
        }
        return ans;
    }

}
