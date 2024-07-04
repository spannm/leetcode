package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/3sum/">15. 3Sum</a>.
 */
class Problem0015 extends LeetcodeProblem {

    List<List<Integer>> threeSum(int[] _nums) {
        int len = _nums.length;
        if (len == 0) {
            return List.of();
        }

        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(_nums);
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = _nums[j] + _nums[k];
                if (sum == -_nums[i]) {
                    set.add(List.of(_nums[i], _nums[j++], _nums[k--]));
                } else if (sum > -_nums[i]) {
                    k--;
                } else if (sum < -_nums[i]) {
                    j++;
                }

            }

        }

        return new ArrayList<>(set);
    }

}
