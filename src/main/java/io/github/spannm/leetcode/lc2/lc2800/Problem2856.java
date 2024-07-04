package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2856. Minimum Array Length After Pair Removals.
 */
class Problem2856 extends LeetcodeProblem {

    int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : cnt.values()) {
            pq.offer(x);
        }
        int ans = nums.size();
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            x--;
            y--;
            if (x > 0) {
                pq.offer(x);
            }
            if (y > 0) {
                pq.offer(y);
            }
            ans -= 2;
        }
        return ans;
    }

}
