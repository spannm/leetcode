package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Problem0636 extends LeetcodeProblem {

    int[] exclusiveTime(int _n, List<String> _logs) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[_n];
        int prevTime = 0;
        for (String log : _logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty()) {
                result[stack.peek()] += Integer.parseInt(parts[2]) - prevTime;
            }
            prevTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) {
                stack.addFirst(Integer.parseInt(parts[0]));
            } else {
                prevTime++;

                result[stack.pollFirst()]++;
            }
        }
        return result;
    }

}
