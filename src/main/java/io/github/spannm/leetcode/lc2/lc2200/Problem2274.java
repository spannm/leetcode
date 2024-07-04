package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2274. Maximum Consecutive Floors Without Special Floors.
 */
class Problem2274 extends LeetcodeProblem {

    int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length;
        int ans = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        return ans;
    }

}
