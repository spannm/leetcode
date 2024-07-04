package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0781 extends LeetcodeProblem {

    int numRabbits(int[] _answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int rabbits = 0;
        for (int rabbitType : _answers) {
            if (map.containsKey(rabbitType)) {
                int count = map.get(rabbitType);
                count--;
                if (count == 0) {
                    map.remove(rabbitType);
                } else {
                    map.put(rabbitType, count);
                }
            } else {
                rabbits += rabbitType;
                rabbits++;
                if (rabbitType != 0) {
                    map.put(rabbitType, rabbitType);
                }
            }
        }
        return rabbits;
    }

}
