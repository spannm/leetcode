package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem1005 extends LeetcodeProblem {

    int largestSumAfterKNegations(int[] _arr, int _k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(_arr).boxed().forEach(minHeap::offer);
        while (_k-- > 0) {
            minHeap.offer(-minHeap.poll());
        }
        int sum = 0;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }
        return sum;
    }

}
