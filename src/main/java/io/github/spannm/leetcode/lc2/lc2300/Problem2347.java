package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem2347 extends LeetcodeProblem {

    String bestHand(int[] _ranks, char[] _suits) {
        Set<Character> set = new HashSet<>();
        for (char c : _suits) {
            set.add(c);
        }
        if (set.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : _ranks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                return "Three of a Kind";
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                return "Pair";
            }
        }
        return "High Card";
    }

}
