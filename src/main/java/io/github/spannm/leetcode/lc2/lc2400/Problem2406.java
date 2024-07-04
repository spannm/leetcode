package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2406. Divide Intervals Into Minimum Number of Groups.
 */
class Problem2406 extends LeetcodeProblem {

    int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<Integer> q = new PriorityQueue<>();
        for (var e : intervals) {
            if (!q.isEmpty() && q.peek() < e[0]) {
                q.poll();
            }
            q.offer(e[1]);
        }
        return q.size();
    }

}
