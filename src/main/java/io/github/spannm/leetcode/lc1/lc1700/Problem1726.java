package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1726 extends LeetcodeProblem {

    int tupleSameProduct(int[] _nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < _nums.length - 1; i++) {
            for (int j = i + 1; j < _nums.length; j++) {
                int product = _nums[i] * _nums[j];
                count += 8 * map.getOrDefault(product, 0);
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        return count;
    }

}
