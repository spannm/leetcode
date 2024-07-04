package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 2334. Subarray With Elements Greater Than Varying Threshold.
 */
class Problem2334 extends LeetcodeProblem {

    int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] >= v) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; i--) {
            int v = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] >= v) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            int k = right[i] - left[i] - 1;
            if (v > threshold / k) {
                return k;
            }
        }
        return -1;
    }

}
