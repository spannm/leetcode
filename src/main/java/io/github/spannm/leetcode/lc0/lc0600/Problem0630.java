package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem0630 extends LeetcodeProblem {

    int scheduleCourse(int[][] _courses) {
        Arrays.sort(_courses, Comparator.comparingInt(a -> a[1]));
        int day = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int[] course : _courses) {
            day += course[0];
            maxHeap.offer(course[0]);
            if (day > course[1]) {
                day -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }

}
