package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 907. Sum of Subarray Minimums.
 */
class Problem0907 extends LeetcodeProblem {

    int sumSubarrayMins(int[] _arr) {
        int len = _arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, -1);
        Arrays.fill(right, len);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && _arr[stk.peek()] >= _arr[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && _arr[stk.peek()] > _arr[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        final int mod = (int) 1e9 + 7;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans += (long) (i - left[i]) * (right[i] - i) % mod * _arr[i] % mod;
            ans %= mod;
        }
        return (int) ans;
    }

}
