package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem2161 extends LeetcodeProblem {

    int[] pivotArray(int[] _nums, int _pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int count = 0;
        for (int num : _nums) {
            if (num < _pivot) {
                less.add(num);
            } else if (num > _pivot) {
                greater.add(num);
            } else {
                count++;
            }
        }
        for (int i = 0; i < _nums.length;) {
            int j = 0;
            while (j < less.size()) {
                _nums[i++] = less.get(j++);
            }
            j = 0;
            while (j < count) {
                _nums[i++] = _pivot;
                j++;
            }
            j = 0;
            while (j < greater.size()) {
                _nums[i++] = greater.get(j++);
            }
        }
        return _nums;
    }

}
