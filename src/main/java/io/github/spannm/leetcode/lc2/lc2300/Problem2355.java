package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 2355. Maximum Number of Books You Can Take.
 */
class Problem2355 extends LeetcodeProblem {

    long maximumBooks(int[] books) {
        int n = books.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = books[i] - i;
        }
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        long ans = 0;
        long[] dp = new long[n];
        dp[0] = books[0];
        for (int i = 0; i < n; i++) {
            int j = left[i];
            int v = books[i];
            int cnt = Math.min(v, i - j);
            int u = v - cnt + 1;
            long s = (long) (u + v) * cnt / 2;
            dp[i] = s + (j == -1 ? 0 : dp[j]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
