package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1696. Jump Game VI.
 */
class Problem1696 extends LeetcodeProblem {

    int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int i = 0; i < n; i++) {
            if (i - q.peekFirst() > k) {
                q.pollFirst();
            }
            f[i] = nums[i] + f[q.peekFirst()];
            while (!q.isEmpty() && f[q.peekLast()] <= f[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return f[n - 1];
    }

}
