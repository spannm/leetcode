package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Problem2363 extends LeetcodeProblem {

    List<List<Integer>> mergeSimilarItems(int[][] _items1, int[][] _items2) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] item : _items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : _items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int key : map.keySet()) {
            result.add(List.of(key, map.get(key)));
        }
        return result;
    }

}
