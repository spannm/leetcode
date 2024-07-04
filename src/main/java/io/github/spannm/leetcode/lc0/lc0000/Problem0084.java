package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0084 extends LeetcodeProblem {

    int largestRectangleArea(int[] _heights) {
        int len = _heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : _heights[i];
            if (s.isEmpty() || h >= _heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, _heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        _heights = null;
        s = null;
        return maxArea;
    }

}
