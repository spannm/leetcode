package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Problem1331 extends LeetcodeProblem {

    int[] arrayRankTransform(int[] _arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : _arr) {
            set.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : set) {
            map.put(num, rank++);
        }
        int[] ranks = new int[_arr.length];
        for (int i = 0; i < _arr.length; i++) {
            ranks[i] = map.get(_arr[i]);
        }
        return ranks;
    }

}
