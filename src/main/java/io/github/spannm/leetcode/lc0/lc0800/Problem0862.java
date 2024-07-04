package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. Shortest Subarray with Sum at Least K.
 */
class Problem0862 extends LeetcodeProblem {

    int shortestSubarray(int[] _nums, int _k) {
        int len = _nums.length;
        long[] s = new long[len + 1];
        for (int i = 0; i < len; i++) {
            s[i + 1] = s[i] + _nums[i];
        }
        Deque<Integer> q = new ArrayDeque<>();
        int ans = len + 1;
        for (int i = 0; i <= len; i++) {
            while (!q.isEmpty() && s[i] - s[q.peek()] >= _k) {
                ans = Math.min(ans, i - q.poll());
            }
            while (!q.isEmpty() && s[q.peekLast()] >= s[i]) {
                q.pollLast();
            }
            q.offer(i);
        }
        return ans > len ? -1 : ans;
    }

}
