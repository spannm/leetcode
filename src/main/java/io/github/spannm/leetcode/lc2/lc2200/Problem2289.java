package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2289. Steps to Make Array Non-decreasing.
 */
class Problem2289 extends LeetcodeProblem {

    int totalSteps(int[] nums) {
        Deque<Integer> stk = new ArrayDeque<>();
        int ans = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[i] > nums[stk.peek()]) {
                dp[i] = Math.max(dp[i] + 1, dp[stk.pop()]);
                ans = Math.max(ans, dp[i]);
            }
            stk.push(i);
        }
        return ans;
    }

}
