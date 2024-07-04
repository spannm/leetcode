package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2420. Find All Good Indices.
 */
class Problem2420 extends LeetcodeProblem {

    List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] decr = new int[n];
        int[] incr = new int[n];
        Arrays.fill(decr, 1);
        Arrays.fill(incr, 1);
        for (int i = 2; i < n - 1; i++) {
            if (nums[i - 1] <= nums[i - 2]) {
                decr[i] = decr[i - 1] + 1;
            }
        }
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i + 1] <= nums[i + 2]) {
                incr[i] = incr[i + 1] + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (decr[i] >= k && incr[i] >= k) {
                ans.add(i);
            }
        }
        return ans;
    }

}
