package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1560 extends LeetcodeProblem {

    List<Integer> mostVisited(int _n, int[] _rounds) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < _rounds.length - 1; i++) {
            if (_rounds[i] > _rounds[i + 1]) {
                if (i == 0) {
                    map.put(_rounds[i], 1);
                }
                for (int j = _rounds[i] + 1; j <= _n; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
                for (int j = 1; j <= _rounds[i + 1]; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            } else {
                int j;
                if (i == 0) {
                    j = _rounds[i];
                } else {
                    j = _rounds[i] + 1;
                }
                for (; j <= _rounds[i + 1]; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
        }

        int mostVisitedCount = 0;
        for (int key : map.keySet()) {
            mostVisitedCount = Math.max(mostVisitedCount, map.get(key));
        }
        for (int key : map.keySet()) {
            if (map.get(key) == mostVisitedCount) {
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }

}
