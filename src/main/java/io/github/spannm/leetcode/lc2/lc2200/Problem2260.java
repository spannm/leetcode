package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/contest/weekly-contest-291/problems/minimum-consecutive-cards-to-pick-up/"> 2260.
 * Minimum Consecutive Cards to Pick Up </a>.
 */
class Problem2260 extends LeetcodeProblem {

    int minimumCardPickup(int[] _cards) {
        if (_cards == null || _cards.length < 2) {
            return -1;
        }
        final Map<Integer, Integer> diffs = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < _cards.length; i++) {
            if (diffs.containsKey(_cards[i])) {
                // check if the difference in indices is smaller than minimum
                min = Math.min(i - diffs.get(_cards[i]) + 1, min);
                if (min == 2) {
                    return 2;
                }
            }
            // update the last found index of the card
            diffs.put(_cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
