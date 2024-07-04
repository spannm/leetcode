package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0301 extends LeetcodeProblem {

    List<String> removeInvalidParentheses(String _s) {
        if (_s == null) {
            return List.of();
        }

        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(_s);
        visited.add(_s);

        boolean found = false;

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (isValid(curr)) {
                found = true;
                result.add(curr);
            }

            if (!found) {
                for (int i = 0; i < curr.length(); i++) {
                    if (curr.charAt(i) != '(' && curr.charAt(i) != ')') {
                        continue;
                    }

                    String next = curr.substring(0, i) + curr.substring(i + 1);
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }

        }
        return result;
    }

    static boolean isValid(String _str) {
        char[] chars = _str.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
                if (count == -1) {
                    return false;
                }
            }
        }
        return count == 0;
    }

}
