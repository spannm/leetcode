package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1801. Number of Orders in the Backlog.
 */
class Problem1801 extends LeetcodeProblem {

    int getNumberOfBacklogOrders(int[][] orders) {
        Queue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Queue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (var e : orders) {
            int p = e[0];
            int a = e[1];
            int t = e[2];
            if (t == 0) {
                while (a > 0 && !sell.isEmpty() && sell.peek()[0] <= p) {
                    var q = sell.poll();
                    int x = q[0];
                    int y = q[1];
                    if (a >= y) {
                        a -= y;
                    } else {
                        sell.offer(new int[] {x, y - a});
                        a = 0;
                    }
                }
                if (a > 0) {
                    buy.offer(new int[] {p, a});
                }
            } else {
                while (a > 0 && !buy.isEmpty() && buy.peek()[0] >= p) {
                    var q = buy.poll();
                    int x = q[0];
                    int y = q[1];
                    if (a >= y) {
                        a -= y;
                    } else {
                        buy.offer(new int[] {x, y - a});
                        a = 0;
                    }
                }
                if (a > 0) {
                    sell.offer(new int[] {p, a});
                }
            }
        }
        long ans = 0;
        final int mod = (int) 1e9 + 7;
        while (!buy.isEmpty()) {
            ans += buy.poll()[1];
        }
        while (!sell.isEmpty()) {
            ans += sell.poll()[1];
        }
        return (int) (ans % mod);
    }

}
