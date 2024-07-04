package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>.
 */
class Problem0300 extends LeetcodeProblem {

    int lengthOfLIS(int[] _nums) {
        int len = _nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int result = 1;

        for (int i = 1; i < len; i++) {
            int num = _nums[i];
            int max = IntStream.range(0, i).filter(j -> _nums[j] < num).map(j -> dp[j]).max().orElse(0);
            dp[i] = max + 1;
            result = Math.max(dp[i], result);
        }

        return result;
    }

}
