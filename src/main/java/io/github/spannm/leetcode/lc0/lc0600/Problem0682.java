package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0682 extends LeetcodeProblem {

    int calPoints(String[] _ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int firstLast = Integer.MIN_VALUE;
        int secondLast = Integer.MIN_VALUE;
        for (String op : _ops) {
            if ("+".equals(op)) {
                if (!stack.isEmpty()) {
                    firstLast = stack.pop();
                }
                if (!stack.isEmpty()) {
                    secondLast = stack.pop();
                }
                int thisRoundPoints = firstLast + secondLast;

                if (secondLast != Integer.MIN_VALUE) {
                    stack.push(secondLast);
                }
                if (firstLast != Integer.MIN_VALUE) {
                    stack.push(firstLast);
                }
                stack.push(thisRoundPoints);
                sum += thisRoundPoints;

                firstLast = Integer.MIN_VALUE;
                secondLast = Integer.MIN_VALUE;
            } else if ("D".equals(op)) {
                if (!stack.isEmpty()) {
                    int thisRoundPoints = stack.peek() * 2;
                    stack.push(thisRoundPoints);
                    sum += thisRoundPoints;
                }
            } else if ("C".equals(op)) {
                if (!stack.isEmpty()) {
                    int removedData = stack.pop();
                    sum -= removedData;
                }
            } else {
                int val = Integer.parseInt(op);
                sum += val;
                stack.push(val);
            }
        }
        return sum;
    }

}
