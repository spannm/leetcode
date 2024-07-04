package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Set;
import java.util.Stack;

class Problem0150 extends LeetcodeProblem {

    int evalRPN(String[] _tokens) {
        Set<String> operators = Set.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (String token : _tokens) {
            if (operators.contains(token)) {
                int secondNum = stack.pop();
                int firstNum = stack.pop();
                int result = switch (token) {
                    case "+" -> firstNum + secondNum;
                    case "-" -> firstNum - secondNum;
                    case "*" -> firstNum * secondNum;
                    default -> firstNum / secondNum;
                };
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        Integer result = stack.pop();

        operators = null;
        stack = null;

        return result;
    }

}
