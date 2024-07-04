package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 915. Partition Array into Disjoint Intervals.
 */
class Problem0915 extends LeetcodeProblem {

    int partitionDisjoint(int[] _nums) {
        int len = _nums.length;
        int[] mi = new int[len + 1];
        mi[len] = _nums[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            mi[i] = Math.min(_nums[i], mi[i + 1]);
        }
        int mx = 0;
        for (int i = 1; i <= len; i++) {
            int v = _nums[i - 1];
            mx = Math.max(mx, v);
            if (mx <= mi[i]) {
                return i;
            }
        }
        return 0;
    }

}
