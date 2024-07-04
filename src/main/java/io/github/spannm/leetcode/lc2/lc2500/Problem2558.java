package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem2558 extends LeetcodeProblem {

    long pickGifts(int[] _gifts, int _k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(_gifts).forEach(maxHeap::offer);
        while (_k-- > 0) {
            int max = maxHeap.poll();
            maxHeap.offer((int) Math.sqrt(max));
        }
        long res = 0L;
        while (!maxHeap.isEmpty()) {
            res += maxHeap.poll();
        }
        return res;
    }

}
