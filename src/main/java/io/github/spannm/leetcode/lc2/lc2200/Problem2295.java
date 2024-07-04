package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2295. Replace Elements in an Array.
 */
class Problem2295 extends LeetcodeProblem {

    int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            d.put(nums[i], i);
        }
        for (var op : operations) {
            int a = op[0];
            int b = op[1];
            nums[d.get(a)] = b;
            d.put(b, d.get(a));
        }
        return nums;
    }

}
