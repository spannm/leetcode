package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1711 extends LeetcodeProblem {
    private static final long MODUALR = 1000000007;

    int countPairs(int[] _deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long pairs = 0;
        for (int element : _deliciousness) {
            int power = 1;

            for (int j = 0; j < 22; j++) {
                if (map.containsKey(power - element)) {
                    pairs += map.get(power - element);
                    pairs %= MODUALR;
                }
                power *= 2;
            }
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        return (int) pairs;
    }

}
