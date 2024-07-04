package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2873. Maximum Value of an Ordered Triplet I.
 */
class Problem2873 extends LeetcodeProblem {

    long maximumTripletValue(int[] nums) {
        long max;
        long maxDiff;
        long ans;
        max = 0;
        maxDiff = 0;
        ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, num * maxDiff);
            max = Math.max(max, num);
            maxDiff = Math.max(maxDiff, max - num);
        }
        return ans;
    }

}
