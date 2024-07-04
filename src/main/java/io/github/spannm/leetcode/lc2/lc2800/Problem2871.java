package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2871. Split Array Into Maximum Number of Subarrays.
 */
class Problem2871 extends LeetcodeProblem {

    int maxSubarrays(int[] nums) {
        int score = -1;
        int ans = 1;
        for (int num : nums) {
            score &= num;
            if (score == 0) {
                ans++;
                score = -1;
            }
        }
        return ans == 1 ? 1 : ans - 1;
    }

}
