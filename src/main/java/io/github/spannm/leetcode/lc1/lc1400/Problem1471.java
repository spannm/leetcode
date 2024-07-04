package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1471 extends LeetcodeProblem {

    int[] getStrongest(int[] _arr, int _k) {
        Arrays.sort(_arr);
        int median = _arr.length % 2 != 0 ? _arr[_arr.length / 2] : _arr[_arr.length / 2 - 1];
        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int num : _arr) {
            int diff = Math.abs(num - median);
            map.computeIfAbsent(diff, k -> new ArrayList<>()).add(num);
        }
        List<Integer> sorted = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            list.sort(Comparator.reverseOrder());
            sorted.addAll(list);
        }
        int[] result = new int[_k];
        for (int i = 0; i < _k; i++) {
            result[i] = sorted.get(i);
        }

        _arr = null;
        map = null;

        return result;
    }

}
