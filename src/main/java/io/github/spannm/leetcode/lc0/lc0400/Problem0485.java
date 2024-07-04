package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0485 extends LeetcodeProblem {

    int findMaxConsecutiveOnes(int[] _nums) {
        int maxLen = 0;
        for (int i = 0; i < _nums.length; i++) {
            int currentLen = 0;
            while (i < _nums.length && _nums[i] == 1) {
                i++;
                currentLen++;
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }

}
