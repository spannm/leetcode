package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1760. Minimum Limit of Balls in a Bag.
 */
class Problem1760 extends LeetcodeProblem {

    int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        while (left < right) {
            int mid = left + right >> 1;
            long cnt = 0;
            for (int x : nums) {
                cnt += (x - 1) / mid;
            }
            if (cnt <= maxOperations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
