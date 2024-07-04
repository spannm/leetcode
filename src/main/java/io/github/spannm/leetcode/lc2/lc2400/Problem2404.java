package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem2404 extends LeetcodeProblem {

    int mostFrequentEven(int[] _nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : _nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> smallestEvens = new ArrayList<>();
        int freq = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > freq) {
                smallestEvens.clear();
                freq = map.get(key);
                smallestEvens.add(key);
            } else if (map.get(key) == freq) {
                smallestEvens.add(key);
            }
        }
        if (smallestEvens.isEmpty()) {
            return -1;
        }
        Collections.sort(smallestEvens);
        return smallestEvens.get(0);
    }

}
