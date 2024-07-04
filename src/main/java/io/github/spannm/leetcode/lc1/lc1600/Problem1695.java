package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem1695 extends LeetcodeProblem {

    int maximumUniqueSubarray(int[] _nums) {
        Set<Integer> set = new HashSet<>();
        int maxSum = 0;
        int runningSum = 0;
        for (int right = 0, left = 0; right < _nums.length; right++) {
            if (set.add(_nums[right])) {
                runningSum += _nums[right];
                maxSum = Math.max(maxSum, runningSum);
            } else {
                while (left < right && set.contains(_nums[right])) {
                    set.remove(_nums[left]);
                    runningSum -= _nums[left];
                    left++;
                }
                set.add(_nums[right]);
                runningSum += _nums[right];
            }
        }
        return maxSum;
    }

}
