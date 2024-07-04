package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3011. Find if Array Can Be Sorted.
 */
class Problem3011 extends LeetcodeProblem {

    boolean canSortArray(int[] nums) {
        int preMx = -300;
        int i = 0;
        int len = nums.length;
        while (i < len) {
            int j = i + 1;
            int cnt = Integer.bitCount(nums[i]);
            int mi = nums[i];
            int mx = nums[i];
            while (j < len && Integer.bitCount(nums[j]) == cnt) {
                mi = Math.min(mi, nums[j]);
                mx = Math.max(mx, nums[j]);
                j++;
            }
            if (preMx > mi) {
                return false;
            }
            preMx = mx;
            i = j;
        }
        return true;
    }

}
