package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2974. Minimum Number Game.
 */
class Problem2974 extends LeetcodeProblem {

    int[] numberGame(int[] _nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int x : _nums) {
            pq.offer(x);
        }
        int[] ans = new int[_nums.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            ans[i++] = pq.poll();
            ans[i++] = a;
        }
        return ans;
    }

}
