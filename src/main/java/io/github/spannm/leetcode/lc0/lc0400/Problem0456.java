package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/132-pattern/">456. 132 Pattern</a>.
 */
class Problem0456 extends LeetcodeProblem {

    boolean find132pattern(int[] _nums) {
        Deque<Integer> stack = new LinkedList<>();

        int s3 = Integer.MIN_VALUE;
        int i = _nums.length - 1;
        for (; i >= 0; i--) {
            if (_nums[i] < s3) {
                break;
            } else {
                while (!stack.isEmpty() && _nums[i] > stack.peek()) {
                    s3 = Math.max(s3, stack.pop());
                }
            }
            stack.push(_nums[i]);
        }

        boolean result = i > -1 && _nums[i] < s3;

        _nums = null;
        stack = null;
        System.gc();

        return result;
    }

}
