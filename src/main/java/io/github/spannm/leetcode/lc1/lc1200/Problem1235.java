package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1235. Maximum Profit in Job Scheduling.
 */
class Problem1235 extends LeetcodeProblem {

    int jobScheduling(int[] _startTime, int[] _endTime, int[] _profit) {
        int len = _profit.length;
        int[][] jobs = new int[len][3];
        for (int i = 0; i < len; i++) {
            jobs[i] = new int[] {_startTime[i], _endTime[i], _profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int j = search(jobs, jobs[i][0], i);
            dp[i + 1] = Math.max(dp[i], dp[j] + jobs[i][2]);
        }
        return dp[len];
    }

    static int search(int[][] _jobs, int _x, int _n) {
        int left = 0;
        int right = _n;
        while (left < right) {
            int mid = left + right >> 1;
            if (_jobs[mid][1] > _x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
