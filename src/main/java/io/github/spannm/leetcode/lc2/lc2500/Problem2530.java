package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem2530 extends LeetcodeProblem {

    long maxKelements(int[] _nums, int _k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(_nums).forEach(maxHeap::offer);
        long ans = 0L;
        while (_k-- > 0) {
            int max = maxHeap.poll();
            ans += max;
            maxHeap.offer((int) Math.ceil((double) max / 3));
        }
        return ans;
    }

}
