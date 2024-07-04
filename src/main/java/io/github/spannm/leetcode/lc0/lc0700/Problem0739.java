package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures.
 */
class Problem0739 extends LeetcodeProblem {

    int[] dailyTemperatures(int[] _temps) {
        int len = _temps.length;
        int[] result = new int[len];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && _temps[stk.peek()] < _temps[i]) {
                int j = stk.pop();
                result[j] = i - j;
            }
            stk.push(i);
        }
        return result;
    }

}
