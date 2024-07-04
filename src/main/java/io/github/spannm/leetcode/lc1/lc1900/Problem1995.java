package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1995 extends LeetcodeProblem {

    int countQuadruplets(int[] _nums) {
        int count = 0;
        for (int i = 0; i < _nums.length - 3; i++) {
            for (int j = i + 1; j < _nums.length - 2; j++) {
                for (int k = j + 1; k < _nums.length - 1; k++) {
                    for (int l = k + 1; l < _nums.length; l++) {
                        if (_nums[i] + _nums[j] + _nums[k] == _nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

}
