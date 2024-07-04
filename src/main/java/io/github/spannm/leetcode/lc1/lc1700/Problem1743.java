package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1743 extends LeetcodeProblem {

    int[] restoreArray(int[][] _adjacentPairs) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int[] pair : _adjacentPairs) {
            int num1 = pair[0];
            int num2 = pair[1];
            map.put(num1, map.getOrDefault(num1, 0) + 1);
            map.put(num2, map.getOrDefault(num2, 0) + 1);
            map2.computeIfAbsent(num1, k -> new ArrayList<>()).add(num2);
            map2.computeIfAbsent(num2, k -> new ArrayList<>()).add(num1);
        }
        int first = map.keySet().stream().filter(k -> map.get(k) == 1).findFirst().orElse(Integer.MAX_VALUE);
        int[] orig = new int[map.size()];
        Set<Integer> set = new HashSet<>();
        orig[0] = first;
        set.add(first);
        for (int i = 1; i < map.size(); i++) {
            int prev = orig[i - 1];
            List<Integer> connected = map2.get(prev);
            for (int conn : connected) {
                if (set.add(conn)) {
                    orig[i] = conn;
                    break;
                }
            }
        }
        return orig;
    }

}
