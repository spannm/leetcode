package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2216. Minimum Deletions to Make Array Beautiful.
 */
class Problem2216 extends LeetcodeProblem {

    int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans++;
            } else {
                i++;
            }
        }
        ans += (n - ans) % 2;
        return ans;
    }

}
