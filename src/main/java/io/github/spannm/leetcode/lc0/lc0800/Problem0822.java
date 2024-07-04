package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 822. Card Flipping Game.
 */
class Problem0822 extends LeetcodeProblem {

    int flipgame(int[] _fronts, int[] _backs) {
        Set<Integer> s = new HashSet<>();
        int n = _fronts.length;
        for (int i = 0; i < n; i++) {
            if (_fronts[i] == _backs[i]) {
                s.add(_fronts[i]);
            }
        }
        int ans = 9999;
        for (int v : _fronts) {
            if (!s.contains(v)) {
                ans = Math.min(ans, v);
            }
        }
        for (int v : _backs) {
            if (!s.contains(v)) {
                ans = Math.min(ans, v);
            }
        }
        return ans % 9999;
    }

}
