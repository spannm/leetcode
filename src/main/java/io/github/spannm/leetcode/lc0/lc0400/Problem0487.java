package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0487 extends LeetcodeProblem {

    static int findMaxConsecutiveOnes(int[] _nums) {
        int left = 0;
        int right = 0;
        int zeroes = 0;
        int ans = 0;
        while (right < _nums.length) {
            if (_nums[right] == 0) {
                zeroes++;
            }
            if (zeroes <= 1) {
                ans = Math.max(ans, right - left + 1);
            } else {
                while (left < _nums.length && zeroes > 1) {
                    if (_nums[left] == 0) {
                        zeroes--;
                    }
                    left++;
                }
            }
            right++;
        }
        return ans;
    }

}
