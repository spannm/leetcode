package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeMap;

class Problem0436 extends LeetcodeProblem {

    int[] findRightInterval(int[][] _intervals) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int[] res = new int[_intervals.length];
        for (int i = 0; i < _intervals.length; i++) {
            tmap.put(_intervals[i][0], i);
        }
        for (int i = 0; i < _intervals.length; i++) {
            Integer key = tmap.ceilingKey(_intervals[i][_intervals[i].length - 1]);
            res[i] = key != null ? tmap.get(key) : -1;
        }
        return res;
    }

}
