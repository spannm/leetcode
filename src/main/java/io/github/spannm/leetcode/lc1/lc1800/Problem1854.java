package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;

class Problem1854 extends LeetcodeProblem {

    int maximumPopulation(int[][] _logs) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] log : _logs) {
            for (int start = log[0]; start < log[1]; start++) {
                map.put(start, map.getOrDefault(start, 0) + 1);
            }
        }
        int maxPop = 0;
        int maxPopYear = 0;
        for (int year : map.keySet()) {
            if (map.get(year) > maxPop) {
                maxPop = map.get(year);
                maxPopYear = year;
            }
        }
        return maxPopYear;
    }

}
