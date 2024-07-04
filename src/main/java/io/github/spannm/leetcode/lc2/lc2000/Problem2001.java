package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2001 extends LeetcodeProblem {

    long interchangeableRectangles(int[][] _rectangles) {
        Map<Double, Integer> map = new HashMap<>();
        for (int[] rec : _rectangles) {
            double ratio = (double) rec[0] / rec[1];
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }
        long answer = 0;
        for (double ratio : map.keySet()) {
            int count = map.get(ratio);
            answer += (long) count * (count - 1) / 2;
        }
        return answer;
    }

}
