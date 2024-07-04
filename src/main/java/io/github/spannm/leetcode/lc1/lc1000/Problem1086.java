package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1086 extends LeetcodeProblem {

    int[][] highFive(int[][] _items) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int[] studentToScore : _items) {
            if (map.containsKey(studentToScore[0])) {
                map.get(studentToScore[0]).add(studentToScore[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(studentToScore[1]);
                map.put(studentToScore[0], list);
            }
        }
        int[][] result = new int[map.size()][2];
        for (int id : map.keySet()) {
            List<Integer> scores = map.get(id);
            Collections.sort(scores);
            int sum = 0;
            for (int i = scores.size() - 1; i >= scores.size() - 5 && i >= 0; i--) {
                sum += scores.get(i);
            }
            result[id - 1][0] = id;
            result[id - 1][1] = sum / 5;
        }
        return result;
    }

}
