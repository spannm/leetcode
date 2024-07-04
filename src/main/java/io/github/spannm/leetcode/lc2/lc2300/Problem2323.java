package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2323. Find Minimum Time to Finish All Jobs II.
 */
class Problem2323 extends LeetcodeProblem {

    int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int ans = 0;
        for (int i = 0; i < jobs.length; i++) {
            ans = Math.max(ans, (jobs[i] + workers[i] - 1) / workers[i]);
        }
        return ans;
    }

}
