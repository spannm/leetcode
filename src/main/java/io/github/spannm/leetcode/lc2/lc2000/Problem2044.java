package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem2044 extends LeetcodeProblem {

    int countMaxOrSubsets(int[] _nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        result.add(empty);
        Arrays.sort(_nums);
        for (int num : _nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                temp.add(newList);
            }
            result.addAll(temp);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : result) {
            if (list.isEmpty()) {
                continue;
            }
            int or = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                or |= list.get(i);
            }
            map.put(or, map.getOrDefault(or, 0) + 1);
        }
        int max = 0;
        int ans = 0;
        for (int key : map.keySet()) {
            if (max < key) {
                max = key;
                ans = map.get(key);
            }
        }
        return ans;
    }

}
