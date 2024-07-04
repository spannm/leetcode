package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0674 extends LeetcodeProblem {

    int findLengthOfLCIS(int[] _nums) {
        int longest = 0;
        for (int i = 0; i < _nums.length; i++) {
            int len = 1;
            for (int j = i + 1; j < _nums.length; j++) {
                if (_nums[j - 1] < _nums[j]) {
                    len++;
                } else {
                    break;
                }
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }

}
