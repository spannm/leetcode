package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1636 extends LeetcodeProblem {

    int[] frequencySort(int[] _nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : _nums) {
            counts.merge(num, 1, Integer::sum);
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            int num = e.getKey();
            int freq = e.getValue();
            map.computeIfAbsent(freq, k -> new ArrayList<>()).add(num);
        }

        int[] result = new int[_nums.length];
        int i = 0;
        for (int num : map.keySet()) {
            List<Integer> list = map.get(num);
            list.sort(Comparator.reverseOrder());
            int k = num;
            for (int j = 0; j < list.size(); j++, k = num) {
                while (k-- > 0) {
                    result[i++] = list.get(j);
                }
            }
        }

        _nums = null;
        map = null;

        return result;
    }

}
