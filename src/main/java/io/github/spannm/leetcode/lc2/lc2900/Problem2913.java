package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2913. Subarrays Distinct Element Sum of Squares I.
 */
class Problem2913 extends LeetcodeProblem {

    int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int[] s = new int[101];
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (++s[nums.get(j)] == 1) {
                    cnt++;
                }
                ans += cnt * cnt;
            }
        }
        return ans;
    }

}
