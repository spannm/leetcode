package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Pair;

import java.util.*;

/**
 * 433. Minimum Genetic Mutation.
 */
class Problem0433 extends LeetcodeProblem {

    int minMutation(String _start, String _end, String[] _bank) {
        Set<String> set = new HashSet<>(Arrays.asList(_bank));
        Map<Character, String> map = Map.of(
            'A', "TCG",
            'T', "ACG",
            'C', "ATG",
            'G', "ATC");
        Deque<Pair<String, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(_start, 0));
        while (!q.isEmpty()) {
            Pair<String, Integer> p = q.poll();
            String t = p.getKey();
            int step = p.getValue();
            if (_end.equals(t)) {
                return step;
            }
            for (int i = 0; i < t.length(); i++) {
                for (char c : map.get(t.charAt(i)).toCharArray()) {
                    String next = t.substring(0, i) + c + t.substring(i + 1);
                    if (set.contains(next)) {
                        q.offer(new Pair<>(next, step + 1));
                        set.remove(next);
                    }
                }
            }
        }
        return -1;
    }

}
