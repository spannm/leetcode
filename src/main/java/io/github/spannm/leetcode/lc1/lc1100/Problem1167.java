package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1167. Minimum Cost to Connect Sticks.
 */
class Problem1167 extends LeetcodeProblem {

    int connectSticks(int[] _sticks) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int x : _sticks) {
            q.offer(x);
        }
        int ans = 0;
        while (q.size() > 1) {
            int z = q.poll() + q.poll();
            ans += z;
            q.offer(z);
        }
        return ans;
    }

}
