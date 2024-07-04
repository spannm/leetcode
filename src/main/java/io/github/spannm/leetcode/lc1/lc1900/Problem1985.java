package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

class Problem1985 extends LeetcodeProblem {

    String kthLargestNumber(String[] _nums, int _k) {
        Queue<String> maxHeap = new PriorityQueue<>((a, b) -> (a.length() != b.length() ? b.length() - a.length() : b.compareTo(a)));
        for (String num : _nums) {
            maxHeap.offer(num);
        }
        while (_k-- > 1) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

}
