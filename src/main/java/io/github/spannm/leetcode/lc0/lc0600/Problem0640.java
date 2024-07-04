package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0640 extends LeetcodeProblem {

    String solveEquation(String _equation) {
        String[] parts = _equation.split("=");
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);
        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
        } else if (left[0] == right[0]) {
            return "No solution";
        }
        return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }

    private static int[] evaluate(String _part) {
        int[] result = new int[2];
        String[] tokens = _part.split("(?=[+-])");
        for (String token : tokens) {
            if ("+x".equals(token) || "x".equals(token)) {
                result[0]++;
            } else if ("-x".equals(token)) {
                result[0]--;
            } else if (token.contains("x")) {
                result[0] += Integer.parseInt(token.substring(0, token.length() - 1));
            } else {
                result[1] += Integer.parseInt(token);
            }
        }
        return result;
    }

}
