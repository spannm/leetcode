package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1063. Number of Valid Subarrays.
 */
class Problem1063 extends LeetcodeProblem {

    int validSubarrays(int[] _nums) {
        int n = _nums.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && _nums[stk.peek()] >= _nums[i]) {
                stk.pop();
            }
            ans += (stk.isEmpty() ? n : stk.peek()) - i;

            stk.push(i);
        }
        return ans;
    }

}
