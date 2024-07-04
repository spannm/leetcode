package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2870. Minimum Number of Operations to Make Array Empty.
 */
class Problem2870 extends LeetcodeProblem {

    int minOperations(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }
        int ans = 0;
        for (int c : count.values()) {
            if (c < 2) {
                return -1;
            }
            int r = c % 3;
            int d = c / 3;
            ans += d;
            if (r != 0) {
                ans++;
            }
        }
        return ans;
    }

}
