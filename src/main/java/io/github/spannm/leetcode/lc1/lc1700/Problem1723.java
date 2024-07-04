package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1723. Find Minimum Time to Finish All Jobs.
 */
class Problem1723 extends LeetcodeProblem {

    private int[] jobs;
    private int   k;
    private int[] cnt;
    private int   ans;

    int minimumTimeRequired(int[] _jobs, int _k) {
        jobs = _jobs;
        Arrays.sort(jobs);
        for (int i = 0, j = jobs.length - 1; i < j; i++, j--) {
            int t = jobs[i];
            jobs[i] = jobs[j];
            jobs[j] = t;
        }
        k = _k;
        cnt = new int[_k];
        ans = 0x3f3f3f3f;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == jobs.length) {
            int mx = 0;
            for (int v : cnt) {
                mx = Math.max(mx, v);
            }
            ans = Math.min(ans, mx);
            return;
        }
        for (int j = 0; j < k; j++) {
            if (cnt[j] + jobs[i] >= ans) {
                continue;
            }
            cnt[j] += jobs[i];
            dfs(i + 1);
            cnt[j] -= jobs[i];
            if (cnt[j] == 0) {
                break;
            }
        }
    }

}
