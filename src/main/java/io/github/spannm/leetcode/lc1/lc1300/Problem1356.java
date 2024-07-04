package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1356 extends LeetcodeProblem {

    int[] sortByBits(int[] _arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : _arr) {
            int count = Integer.bitCount(num);
            map.computeIfAbsent(count, k -> new ArrayList<>()).add(num);
        }
        int[] result = new int[_arr.length];
        int i = 0;
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            for (int num : list) {
                result[i++] = num;
            }
        }
        map = null;
        return result;
    }

}
