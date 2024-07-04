package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;

class Problem1133 extends LeetcodeProblem {

    int largestUniqueNumber(int[] _arr) {
        Map<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        for (int num : _arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (1 == e.getValue()) {
                return e.getKey();
            }
        }
        return -1;
    }

}
