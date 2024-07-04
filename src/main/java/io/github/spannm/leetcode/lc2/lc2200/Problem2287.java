package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2287 extends LeetcodeProblem {

    int rearrangeCharacters(String _s, String _target) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : _target.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : _s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        int result = Integer.MAX_VALUE;
        for (char c : targetMap.keySet()) {
            int targetCount = targetMap.get(c);
            result = Math.min(result, sMap.getOrDefault(c, 0) / targetCount);
        }
        return result;
    }

}
