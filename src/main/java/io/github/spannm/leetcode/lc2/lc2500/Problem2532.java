package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2532. Time to Cross a Bridge.
 */
class Problem2532 extends LeetcodeProblem {

    int findCrossingTime(int n, int k, int[][] time) {
        int[][] t = new int[k][5];
        for (int i = 0; i < k; i++) {
            int[] x = time[i];
            t[i] = new int[] {x[0], x[1], x[2], x[3], i};
        }
        Arrays.sort(t, (a, b) -> {
            int x = a[0] + a[2];
            int y = b[0] + b[2];
            return x == y ? a[4] - b[4] : x - y;
        });
        int cur = 0;
        Queue<Integer> waitInLeft = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> waitInRight = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> workInLeft = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Queue<int[]> workInRight = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < k; i++) {
            waitInLeft.offer(i);
        }
        while (true) {
            while (!workInLeft.isEmpty()) {
                int[] p = workInLeft.peek();
                if (p[0] > cur) {
                    break;
                }
                waitInLeft.offer(workInLeft.poll()[1]);
            }
            while (!workInRight.isEmpty()) {
                int[] p = workInRight.peek();
                if (p[0] > cur) {
                    break;
                }
                waitInRight.offer(workInRight.poll()[1]);
            }
            boolean leftToGo = n > 0 && !waitInLeft.isEmpty();
            boolean rightToGo = !waitInRight.isEmpty();
            if (!leftToGo && !rightToGo) {
                int nxt = 1 << 30;
                if (!workInLeft.isEmpty()) {
                    nxt = Math.min(nxt, workInLeft.peek()[0]);
                }
                if (!workInRight.isEmpty()) {
                    nxt = Math.min(nxt, workInRight.peek()[0]);
                }
                cur = nxt;
                continue;
            }
            if (rightToGo) {
                int i = waitInRight.poll();
                cur += t[i][2];
                if (n == 0 && waitInRight.isEmpty() && workInRight.isEmpty()) {
                    return cur;
                }
                workInLeft.offer(new int[] {cur + t[i][3], i});
            } else {
                int i = waitInLeft.poll();
                cur += t[i][0];
                n--;
                workInRight.offer(new int[] {cur + t[i][1], i});
            }
        }
    }

}
