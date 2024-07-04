package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem2395 extends LeetcodeProblem {

    boolean findSubarrays(int[] _nums) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < _nums.length - 1; i++) {
            int sum = _nums[i] + _nums[i + 1];
            if (!sums.add(sum)) {
                return true;
            }
        }
        return false;
    }

}
