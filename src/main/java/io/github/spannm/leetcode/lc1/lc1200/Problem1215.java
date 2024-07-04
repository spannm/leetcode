package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1215. Stepping Numbers.
 */
class Problem1215 extends LeetcodeProblem {

    List<Integer> countSteppingNumbers(int _low, int _high) {
        List<Integer> ans = new ArrayList<>();
        if (_low == 0) {
            ans.add(0);
        }
        Deque<Long> q = new ArrayDeque<>();
        for (long i = 1; i < 10; i++) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            long v = q.pollFirst();
            if (v > _high) {
                break;
            }
            if (v >= _low) {
                ans.add((int) v);
            }
            int x = (int) v % 10;
            if (x > 0) {
                q.offer(v * 10 + x - 1);
            }
            if (x < 9) {
                q.offer(v * 10 + x + 1);
            }
        }
        return ans;
    }

}
