package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem0368 extends LeetcodeProblem {

    List<Integer> largestDivisibleSubset(int[] _nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(_nums);
        int len = _nums.length;
        if (len == 0) {
            return List.of();
        }
        for (int i = 0; i < len; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            List<Integer> maxSubset = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                if (_nums[i] % _nums[k] == 0 && maxSubset.size() < lists.get(k).size()) {
                    maxSubset = lists.get(k);
                }
            }
            lists.get(i).addAll(maxSubset);
            lists.get(i).add(_nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> list : lists) {
            if (list.size() > ans.size()) {
                ans.clear();
                ans.addAll(list);
            }
        }
        return ans;
    }

}
