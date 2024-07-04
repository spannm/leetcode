package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeMap;

class Problem1725 extends LeetcodeProblem {

    int countGoodRectangles(int[][] _rectangles) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for (int[] rec : _rectangles) {
            int min = Math.min(rec[0], rec[1]);
            tmap.put(min, tmap.getOrDefault(min, 0) + 1);
        }
        return tmap.lastEntry().getValue();
    }

}
