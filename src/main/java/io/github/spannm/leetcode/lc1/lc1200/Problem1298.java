package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1298. Maximum Candies You Can Get from Boxes.
 */
class Problem1298 extends LeetcodeProblem {

    int maxCandies(int[] _status, int[] _candies, int[][] _keys, int[][] _containedBoxes, int[] _initialBoxes) {
        int ans = 0;
        int n = _status.length;
        boolean[] has = new boolean[n];
        boolean[] took = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i : _initialBoxes) {
            has[i] = true;
            if (_status[i] == 1) {
                ans += _candies[i];
                took[i] = true;
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int k : _keys[i]) {
                _status[k] = 1;
                if (has[k] && !took[k]) {
                    ans += _candies[k];
                    took[k] = true;
                    q.offer(k);
                }
            }
            for (int j : _containedBoxes[i]) {
                has[j] = true;
                if (_status[j] == 1 && !took[j]) {
                    ans += _candies[j];
                    took[j] = true;
                    q.offer(j);
                }
            }
        }
        return ans;
    }

}
