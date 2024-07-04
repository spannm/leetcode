package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2350. Shortest Impossible Sequence of Rolls.
 */
class Problem2350 extends LeetcodeProblem {

    int shortestSequence(int[] rolls, int k) {
        Set<Integer> s = new HashSet<>();
        int ans = 1;
        for (int v : rolls) {
            s.add(v);
            if (s.size() == k) {
                s.clear();
                ans++;
            }
        }
        return ans;
    }

}
