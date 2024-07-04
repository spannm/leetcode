package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1665. Minimum Initial Energy to Finish Tasks.
 */
class Problem1665 extends LeetcodeProblem {

    int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[0] - b[0] - (a[1] - b[1]));
        int ans = 0;
        int cur = 0;
        for (var task : tasks) {
            int a = task[0];
            int m = task[1];
            if (cur < m) {
                ans += m - cur;
                cur = m;
            }
            cur -= a;
        }
        return ans;
    }

}
