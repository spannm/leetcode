package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2599. Make the Prefix Sum Non-negative.
 */
class Problem2599 extends LeetcodeProblem {

    int makePrefSumNonNegative(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        long s = 0;
        for (int x : nums) {
            s += x;
            if (x < 0) {
                pq.offer(x);
            }
            while (s < 0) {
                s -= pq.poll();
                ans++;
            }
        }
        return ans;
    }

}
