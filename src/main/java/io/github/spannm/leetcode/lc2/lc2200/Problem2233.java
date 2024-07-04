package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2233. Maximum Product After K Increments.
 */
class Problem2233 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int maximumProduct(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int v : nums) {
            q.offer(v);
        }
        while (k-- > 0) {
            q.offer(q.poll() + 1);
        }
        long ans = 1;
        while (!q.isEmpty()) {
            ans = ans * q.poll() % MOD;
        }
        return (int) ans;
    }

}
