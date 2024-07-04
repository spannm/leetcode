package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target.
 */
class Problem1546 extends LeetcodeProblem {

    int maxNonOverlapping(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> vis = new HashSet<>();
            int s = 0;
            vis.add(0);
            while (i < n) {
                s += nums[i];
                if (vis.contains(s - target)) {
                    ans++;
                    break;
                }
                i++;
                vis.add(s);
            }
        }
        return ans;
    }

}
