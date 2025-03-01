package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2282. Number of People That Can Be Seen in a Grid.
 */
class Problem2282 extends LeetcodeProblem {

    int[][] seePeople(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] ans = new int[m][0];
        for (int i = 0; i < m; i++) {
            ans[i] = f(heights[i]);
        }
        for (int j = 0; j < n; j++) {
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = heights[i][j];
            }
            int[] add = f(nums);
            for (int i = 0; i < m; i++) {
                ans[i][j] += add[i];
            }
        }
        return ans;
    }

    private int[] f(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                stk.pop();
                ans[i]++;
            }
            if (!stk.isEmpty()) {
                ans[i]++;
            }
            while (!stk.isEmpty() && stk.peek() == nums[i]) {
                stk.pop();
            }
            stk.push(nums[i]);
        }
        return ans;
    }

}
