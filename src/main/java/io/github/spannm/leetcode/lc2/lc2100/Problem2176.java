package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem2176 extends LeetcodeProblem {

    int countPairs(int[] _nums, int _k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < _nums.length; i++) {
            List<Integer> list = map.getOrDefault(_nums[i], new ArrayList<>());
            list.add(i);
            map.put(_nums[i], list);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) * list.get(j) % _k == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
