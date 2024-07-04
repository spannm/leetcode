package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2589. Minimum Time to Complete All Tasks.
 */
class Problem2589 extends LeetcodeProblem {

    int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int[] vis = new int[2010];
        int ans = 0;
        for (var task : tasks) {
            int start = task[0];
            int end = task[1];
            int duration = task[2];
            for (int i = start; i <= end; i++) {
                duration -= vis[i];
            }
            for (int i = end; i >= start && duration > 0; i--) {
                if (vis[i] == 0) {
                    duration--;
                    ans += vis[i] = 1;
                }
            }
        }
        return ans;
    }

}
