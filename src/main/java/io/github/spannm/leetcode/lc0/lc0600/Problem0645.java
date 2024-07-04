package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0645 extends LeetcodeProblem {

    int[] findErrorNums(int[] _nums) {
        int[] result = new int[2];
        Arrays.sort(_nums);
        for (int i = 0; i < _nums.length - 1; i++) {
            if (_nums[i + 1] == _nums[i]) {
                result[0] = _nums[i];
            }
        }
        long temp = 0;
        for (int i = 0; i < _nums.length; i++) {
            temp += i + 1;
            temp -= _nums[i];
        }
        temp += result[0];
        result[1] = (int) temp;
        return result;
    }

}
