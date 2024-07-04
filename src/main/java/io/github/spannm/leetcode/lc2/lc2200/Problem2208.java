package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

class Problem2208 extends LeetcodeProblem {

    int halveArray(int[] _nums) {
        Queue<Double> heap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double sum = 0;
        for (int num : _nums) {
            heap.offer((double) num);
            sum += num;
        }
        double half = sum / 2;
        int ops = 0;
        while (sum > half) {
            Double max = heap.poll();
            sum -= max;
            double h = max / 2;
            sum += h;
            heap.offer(h);
            ops++;
        }
        return ops;
    }

}
