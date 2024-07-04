package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2170. Minimum Operations to Make the Array Alternating.
 */
class Problem2170 extends LeetcodeProblem {

    private int[] nums;
    private int   len;

    int minimumOperations(int[] _nums) {
        nums = _nums;
        len = _nums.length;
        int ans = Integer.MAX_VALUE;
        for (int[] e1 : get(0)) {
            for (int[] e2 : get(1)) {
                if (e1[0] != e2[0]) {
                    ans = Math.min(ans, len - (e1[1] + e2[1]));
                }
            }
        }
        return ans;
    }

    private int[][] get(int _i) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (; _i < len; _i += 2) {
            freq.put(nums[_i], freq.getOrDefault(nums[_i], 0) + 1);
        }
        int a = 0;
        int n1 = 0;
        int b = 0;
        int n2 = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();
            if (v > n1) {
                b = a;
                n2 = n1;
                a = k;
                n1 = v;
            } else if (v > n2) {
                b = k;
                n2 = v;
            }
        }
        return new int[][] {{a, n1}, {b, n2}};
    }

}
