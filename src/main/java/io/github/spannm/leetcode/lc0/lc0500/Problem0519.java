package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 519. Random Flip Matrix.
 */
class Problem0519 extends LeetcodeProblem {

    static class Solution {
        private final int                   row;
        private final int                   col;
        private int                         total;
        private final Random                rand = new Random();
        private final Map<Integer, Integer> mp   = new HashMap<>();

        Solution(int _row, int _col) {
            row = _row;
            col = _col;
            total = _row * _col;
        }

        int[] flip() {
            int x = rand.nextInt(total--);
            int idx = mp.getOrDefault(x, x);
            mp.put(x, mp.getOrDefault(total, total));
            return new int[] {idx / col, idx % col};
        }

        void reset() {
            total = row * col;
            mp.clear();
        }
    }

}
