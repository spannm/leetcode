package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/">1838. Frequency of the Most Frequent
 * Element</a>.
 */
class Problem1838 extends LeetcodeProblem {

    int maxFrequency(int[] _nums, int _k) {
        Arrays.sort(_nums);

        long total = 0;
        int ans = 0;
        for (int right = 0, left = 0; right < _nums.length; right++) {
            total += _nums[right];

            while (_nums[right] * (right - left + 1) > total + _k) {
                total -= _nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
