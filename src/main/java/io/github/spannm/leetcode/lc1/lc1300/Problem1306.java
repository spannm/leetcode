package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 1306. Jump Game III.
 */
class Problem1306 extends LeetcodeProblem {

    boolean canReach(int[] arr, int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) {
                return true;
            }
            int x = arr[i];
            arr[i] = -1;
            for (int j : List.of(i + x, i - x)) {
                if (j >= 0 && j < arr.length && arr[j] >= 0) {
                    q.offer(j);
                }
            }
        }
        return false;
    }

}
