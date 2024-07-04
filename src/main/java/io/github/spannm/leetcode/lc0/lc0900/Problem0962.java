package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 962. Maximum Width Ramp.
 */
class Problem0962 extends LeetcodeProblem {

    int maxWidthRamp(int[] _nums) {
        int n = _nums.length;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty() || _nums[stk.peek()] > _nums[i]) {
                stk.push(i);
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && _nums[stk.peek()] <= _nums[i]) {
                ans = Math.max(ans, i - stk.pop());
            }
            if (stk.isEmpty()) {
                break;
            }
        }
        return ans;
    }

}
