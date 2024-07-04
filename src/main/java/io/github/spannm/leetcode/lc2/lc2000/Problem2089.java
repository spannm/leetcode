package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem2089 extends LeetcodeProblem {

    List<Integer> targetIndices(int[] _nums, int _target) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(_nums);
        for (int i = 0; i < _nums.length; i++) {
            if (_nums[i] == _target) {
                ans.add(i);
            }
        }
        return ans;
    }

}
