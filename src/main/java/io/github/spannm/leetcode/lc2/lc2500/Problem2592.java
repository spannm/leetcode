package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2592. Maximize Greatness of an Array.
 */
class Problem2592 extends LeetcodeProblem {

    int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (int x : nums) {
            if (x > nums[i]) {
                i++;
            }
        }
        return i;
    }

}
