package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1365 extends LeetcodeProblem {

    int[] smallerNumbersThanCurrent(int[] _nums) {
        int[] result = new int[_nums.length];
        int[] tmp = Arrays.copyOf(_nums, _nums.length);
        Arrays.sort(tmp);
        List<Integer> list = new ArrayList<>();
        for (int i : tmp) {
            list.add(i);
        }
        for (int i = 0; i < _nums.length; i++) {
            result[i] = list.indexOf(_nums[i]);
        }
        return result;
    }

}
