package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1128 extends LeetcodeProblem {

    int numEquivDominoPairs(int[][] _dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] dominoe : _dominoes) {
            int smaller = Math.min(dominoe[0], dominoe[1]);
            int bigger = Math.max(dominoe[0], dominoe[1]);
            int key = smaller * 10 + bigger;
            count += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;
    }

}
