package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1010 extends LeetcodeProblem {

    int numPairsDivisibleBy60(int[] _time) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : _time) {
            int d = (60 - t % 60) % 60;
            if (map.containsKey(d)) {
                result += map.get(d);
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return result;
    }

}
