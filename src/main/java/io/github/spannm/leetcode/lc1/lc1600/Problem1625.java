package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Problem1625 extends LeetcodeProblem {

    String findLexSmallestString(String _s, int _a, int _b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.offer(_s);
        String smallest = _s;
        while (!queue.isEmpty()) {
            String current = queue.poll();

            char[] c = current.toCharArray();
            for (int i = 1; i < c.length; i++) {
                if (i % 2 == 1) {
                    c[i] = (char) ((Integer.parseInt(String.valueOf(c[i])) + _a) % 10 + '0');
                }
            }
            String next = new String(c);
            if (smallest.compareTo(next) > 0) {
                smallest = next;
            }
            if (seen.add(next)) {
                queue.add(next);
            }

            next = next.substring(next.length() - _b) + next.substring(0, next.length() - _b);
            if (seen.add(next)) {
                queue.add(next);
            }
            if (smallest.compareTo(next) > 0) {
                smallest = next;
            }
        }
        return smallest;
    }

}
