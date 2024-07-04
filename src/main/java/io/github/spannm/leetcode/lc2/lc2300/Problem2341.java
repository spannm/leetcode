package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2341 extends LeetcodeProblem {

    int[] numberOfPairs(int[] _nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : _nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int pairs = 0;
        int leftover = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                pairs += map.get(key) / 2;
                leftover += map.get(key) % 2;
            } else {
                leftover++;
            }
        }
        return new int[] {pairs, leftover};
    }

}
