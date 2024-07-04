package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0503 extends LeetcodeProblem {

    int[] nextGreaterElements(int[] _nums) {
        if (_nums == null || _nums.length == 0) {
            return _nums;
        }
        int len = _nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            stack.push(i);

        }
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            result[i] = -1;

            while (!stack.isEmpty() && _nums[stack.peek()] <= _nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = _nums[stack.peek()];
            }
            stack.push(i);
        }
        return result;
    }

}
