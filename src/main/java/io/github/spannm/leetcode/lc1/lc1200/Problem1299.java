package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem1299 extends LeetcodeProblem {

    int[] replaceElements(int[] _arr) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(_arr).boxed().forEach(heap::offer);
        int[] result = new int[_arr.length];
        for (int i = 0; i < _arr.length - 1; i++) {
            heap.remove(_arr[i]);
            result[i] = heap.peek();
        }
        result[_arr.length - 1] = -1;
        return result;
    }

}
