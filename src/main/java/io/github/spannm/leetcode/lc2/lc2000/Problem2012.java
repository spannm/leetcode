package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem2012 extends LeetcodeProblem {

    int sumOfBeauties(int[] _nums) {
        int[] preMax = new int[_nums.length];
        preMax[0] = _nums[0];
        int max = _nums[0];
        for (int i = 1; i < _nums.length; i++) {
            max = Math.max(max, _nums[i]);
            preMax[i] = max;
        }
        int[] postMin = new int[_nums.length];
        Arrays.fill(postMin, Integer.MAX_VALUE);
        int min = _nums[_nums.length - 1];
        postMin[_nums.length - 1] = _nums[_nums.length - 1];
        for (int i = _nums.length - 2; i >= 0; i--) {
            min = Math.min(min, _nums[i]);
            postMin[i] = min;
        }
        int sum = 0;
        for (int i = 1; i <= _nums.length - 2; i++) {
            if (_nums[i] > preMax[i - 1] && _nums[i] < postMin[i + 1]) {
                sum += 2;
            } else if (_nums[i] > _nums[i - 1] && _nums[i] < _nums[i + 1]) {
                sum++;
            }
        }
        return sum;
    }

}
