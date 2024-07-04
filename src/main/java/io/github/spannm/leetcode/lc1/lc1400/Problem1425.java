package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/constrained-subsequence-sum/">1425. Constrained Subsequence Sum</a>.
 */
class Problem1425 extends LeetcodeProblem {

    int constrainedSubsetSum(int[] _nums, int _k) {
        final int len = _nums.length;
        int[] dp = new int[len];
        int max = _nums[0];
        Queue<Integer> scores = new PriorityQueue<>((a, b) -> dp[b] - dp[a]);
        for (int i = 0; i < len; i++) {
            dp[i] = _nums[i];
            while (!scores.isEmpty() && scores.peek() < i - _k) {
                scores.poll();
            }
            if (!scores.isEmpty()) {
                dp[i] += dp[scores.peek()];
            }
            max = Math.max(max, dp[i]);
            if (dp[i] > 0) {
                scores.offer(i);
            }
        }
        return max;
    }

}
