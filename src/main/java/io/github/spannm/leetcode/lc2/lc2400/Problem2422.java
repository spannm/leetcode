package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2422. Merge Operations to Turn Array Into a Palindrome.
 */
class Problem2422 extends LeetcodeProblem {

    int minimumOperations(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        long a = nums[i];
        long b = nums[j];
        int ans = 0;
        while (i < j) {
            if (a < b) {
                a += nums[++i];
                ans++;
            } else if (b < a) {
                b += nums[--j];
                ans++;
            } else {
                a = nums[++i];
                b = nums[--j];
            }
        }
        return ans;
    }

}
