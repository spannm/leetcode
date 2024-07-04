package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1338 extends LeetcodeProblem {

    int minSetSize(int[] _arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : _arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int k : map.keySet()) {
            list.add(map.get(k));
        }
        list.sort(Comparator.reverseOrder());
        int sum = 0;
        int i = 0;
        while (sum < _arr.length / 2) {
            sum += list.get(i++);
        }
        return i--;
    }

}
