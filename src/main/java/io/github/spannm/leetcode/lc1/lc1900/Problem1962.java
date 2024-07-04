package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1962. Remove Stones to Minimize the Total.
 */
class Problem1962 extends LeetcodeProblem {

    int minStoneSum(int[] piles, int k) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for (int p : piles) {
            q.offer(p);
        }
        while (k-- > 0) {
            int p = q.poll();
            q.offer(p + 1 >> 1);
        }
        int ans = 0;
        while (!q.isEmpty()) {
            ans += q.poll();
        }
        return ans;
    }

}
