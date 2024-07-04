package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.List;

class Problem0241 extends LeetcodeProblem {

    List<Integer> diffWaysToCompute(String _input) {
        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < _input.length(); i++) {
            char c = _input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = _input.substring(0, i);
                String part2 = _input.substring(i + 1);
                List<Integer> answer1 = diffWaysToCompute(part1);
                List<Integer> answer2 = diffWaysToCompute(part2);
                for (int a1 : answer1) {
                    for (int a2 : answer2) {
                        int result = 0;
                        switch (c) {
                            case '+' -> result = a1 + a2;
                            case '-' -> result = a1 - a2;
                            case '*' -> result = a1 * a2;
                            default -> { }
                        }
                        answer.add(result);
                    }
                }
            }
        }
        if (answer.isEmpty()) {
            answer.add(Integer.valueOf(_input));
        }
        return answer;
    }

}
