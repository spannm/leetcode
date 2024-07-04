package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2190 extends LeetcodeProblem {

    int mostFrequent(int[] _nums, int _key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < _nums.length - 1; i++) {
            if (_nums[i] == _key) {
                map.put(_nums[i + 1], map.getOrDefault(_nums[i + 1], 0) + 1);
            }
        }
        int most = 0;
        int ans = 0;
        for (int k : map.keySet()) {
            if (map.get(k) > most) {
                ans = k;
                most = map.get(k);
            }
        }
        return ans;
    }

}
