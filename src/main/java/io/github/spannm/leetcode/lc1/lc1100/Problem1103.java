package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1103 extends LeetcodeProblem {

    int[] distributeCandies(int _candies, int _numPeople) {
        Map<Integer, Integer> map = new HashMap<>();
        int candy = 1;
        while (_candies > 0) {
            for (int person = 1; person <= _numPeople && _candies > 0; person++, candy++) {
                if (_candies < candy) {
                    map.put(person, map.getOrDefault(person, 0) + _candies);
                    _candies -= candy;
                    break;
                } else {
                    map.put(person, map.getOrDefault(person, 0) + candy);
                    _candies -= candy;
                }
            }
        }
        int[] result = new int[_numPeople];
        for (int i = 1; i <= _numPeople; i++) {
            result[i - 1] = map.getOrDefault(i, 0);
        }
        return result;
    }

}
