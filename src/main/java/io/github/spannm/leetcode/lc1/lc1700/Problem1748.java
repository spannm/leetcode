package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1748 extends LeetcodeProblem {

    int sumOfUnique(int[] _nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num : _nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }

}
