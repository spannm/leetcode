package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1199. Minimum Time to Build Blocks.
 */
class Problem1199 extends LeetcodeProblem {

    int minBuildTime(int[] _blocks, int _split) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int x : _blocks) {
            q.offer(x);
        }
        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll() + _split);
        }
        return q.poll();
    }

}
