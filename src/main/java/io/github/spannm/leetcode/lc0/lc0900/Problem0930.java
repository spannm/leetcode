package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 930. Binary Subarrays With Sum.
 */
class Problem0930 extends LeetcodeProblem {

    int numSubarraysWithSum(int[] _nums, int _goal) {
        int len = _nums.length;
        int j = 0;
        int s1 = 0;
        int s2 = 0;
        int i1 = 0;
        int i2 = 0;
        int result = 0;
        while (j < len) {
            s1 += _nums[j];
            s2 += _nums[j];
            while (i1 <= j && s1 > _goal) {
                s1 -= _nums[i1++];
            }
            while (i2 <= j && s2 >= _goal) {
                s2 -= _nums[i2++];
            }
            result += i2 - i1;
            j++;
        }
        return result;
    }

}
