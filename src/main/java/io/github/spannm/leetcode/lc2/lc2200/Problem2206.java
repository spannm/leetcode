package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2206 extends LeetcodeProblem {

    boolean divideArray(int[] _nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : _nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

}
