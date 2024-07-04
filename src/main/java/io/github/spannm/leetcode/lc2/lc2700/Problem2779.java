package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2779. Maximum Beauty of an Array After Applying Operation.
 */
class Problem2779 extends LeetcodeProblem {

    int maximumBeauty(int[] nums, int k) {
        int m = Arrays.stream(nums).max().getAsInt() + k * 2 + 2;
        int[] d = new int[m];
        for (int x : nums) {
            d[x]++;
            d[x + k * 2 + 1]--;
        }
        int ans = 0;
        int s = 0;
        for (int x : d) {
            s += x;
            ans = Math.max(ans, s);
        }
        return ans;
    }

}
