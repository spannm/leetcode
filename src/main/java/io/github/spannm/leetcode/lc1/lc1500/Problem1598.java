package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1598 extends LeetcodeProblem {

    int minOperations(String[] _logs) {
        int steps = 0;
        for (String log : _logs) {
            if ("../".equals(log)) {
                if (steps > 0) {
                    steps--;
                }
            } else if (!"./".equals(log)) {
                steps++;
            }
        }
        return steps;
    }

}
