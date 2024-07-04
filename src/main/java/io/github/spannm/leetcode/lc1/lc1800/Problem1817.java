package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1817 extends LeetcodeProblem {

    int[] findingUsersActiveMinutes(int[][] _logs, int _k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : _logs) {
            map.computeIfAbsent(log[0], k -> new HashSet<>()).add(log[1]);
        }
        int[] result = new int[_k];
        Map<Integer, Integer> tmap = new TreeMap<>();
        for (int key : map.keySet()) {
            int uam = map.get(key).size();
            tmap.put(uam, tmap.getOrDefault(uam, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : tmap.entrySet()) {
            result[e.getKey() - 1] = e.getValue();
        }
        return result;
    }

}
