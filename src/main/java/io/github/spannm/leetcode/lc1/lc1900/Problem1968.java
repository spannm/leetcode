package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1968 extends LeetcodeProblem {

    int[] rearrangeArray(int[] _nums) {
        Arrays.sort(_nums);
        int[] result = new int[_nums.length];
        int j = 1;
        for (int i = 0; i < _nums.length / 2; i++) {
            result[j] = _nums[i];
            j += 2;
        }
        j = 0;
        for (int i = _nums.length / 2; i < _nums.length; i++) {
            result[j] = _nums[i];
            j += 2;
        }
        return result;
    }

}
