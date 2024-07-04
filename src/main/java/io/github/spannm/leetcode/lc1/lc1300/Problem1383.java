package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1383. Maximum Performance of a Team.
 */
class Problem1383 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] t = new int[n][2];
        for (int i = 0; i < n; i++) {
            t[i] = new int[] {speed[i], efficiency[i]};
        }
        Arrays.sort(t, (a, b) -> b[1] - a[1]);
        Queue<Integer> q = new PriorityQueue<>();
        long tot = 0;
        long ans = 0;
        for (var x : t) {
            int s = x[0];
            int e = x[1];
            tot += s;
            ans = Math.max(ans, tot * e);
            q.offer(s);
            if (q.size() == k) {
                tot -= q.poll();
            }
        }
        return (int) (ans % MOD);
    }

}
