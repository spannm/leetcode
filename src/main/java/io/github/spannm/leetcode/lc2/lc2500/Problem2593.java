package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2593. Find Score of an Array After Marking All Elements.
 */
class Problem2593 extends LeetcodeProblem {

    long findScore(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            q.offer(new int[] {nums[i], i});
        }
        long ans = 0;
        while (!q.isEmpty()) {
            var p = q.poll();
            ans += p[0];
            vis[p[1]] = true;
            for (int j : List.of(p[1] - 1, p[1] + 1)) {
                if (j >= 0 && j < n) {
                    vis[j] = true;
                }
            }
            while (!q.isEmpty() && vis[q.peek()[1]]) {
                q.poll();
            }
        }
        return ans;
    }

}
