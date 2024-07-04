package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem1673 extends LeetcodeProblem {

    int[] mostCompetitive(int[] _nums, int _k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < _nums.length; i++) {
            while (!stack.isEmpty() && _nums[i] < stack.peek() && _nums.length - i + stack.size() > _k) {
                stack.pop();
            }
            if (stack.size() < _k) {
                stack.push(_nums[i]);
            }
        }
        int[] result = new int[_k];
        for (int i = _k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

}
