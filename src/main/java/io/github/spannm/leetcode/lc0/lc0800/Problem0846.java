package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 846. Hand of Straights.
 */
class Problem0846 extends LeetcodeProblem {

    boolean isNStraightHand(int[] _hand, int _groupSize) {
        int len = _hand.length;
        if (len % _groupSize != 0) {
            return false;
        } else if (_groupSize == 1) {
            return true;
        }

        Arrays.sort(_hand);
        Map<Integer, Long> counts = Arrays.stream(_hand).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        for (int card : _hand) {
            if (counts.containsKey(card)) {
                for (int x = card; x < card + _groupSize; x++) {
                    if (!counts.containsKey(x)) {
                        return false;
                    }
                    Long newCount = counts.compute(x, (k, v) -> v - 1);
                    if (newCount == 0) {
                        counts.remove(x);
                    }
                }
            }
        }
        return true;
    }

}
