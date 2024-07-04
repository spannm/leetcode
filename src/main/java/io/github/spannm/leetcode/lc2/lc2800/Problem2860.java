package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Collections;
import java.util.List;

/**
 * 2860. Happy Students.
 */
class Problem2860 extends LeetcodeProblem {

    int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if ((i == 0 || nums.get(i - 1) < i) && (i == n || nums.get(i) > i)) {
                ans++;
            }
        }
        return ans;
    }

}
