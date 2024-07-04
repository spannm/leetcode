package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.IntBinaryOperator;

/**
 * 2059. Minimum Operations to Convert Number.
 */
class Problem2059 extends LeetcodeProblem {

    int minimumOperations(int[] nums, int start, int goal) {
        IntBinaryOperator op1 = Integer::sum;
        IntBinaryOperator op2 = (x, y) -> x - y;
        IntBinaryOperator op3 = (x, y) -> x ^ y;
        IntBinaryOperator[] ops = {op1, op2, op3};
        boolean[] vis = new boolean[1001];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int step = p[1];
            for (int num : nums) {
                for (IntBinaryOperator op : ops) {
                    int nx = op.applyAsInt(x, num);
                    if (nx == goal) {
                        return step + 1;
                    }
                    if (nx >= 0 && nx <= 1000 && !vis[nx]) {
                        queue.offer(new int[] {nx, step + 1});
                        vis[nx] = true;
                    }
                }
            }
        }
        return -1;
    }

}
