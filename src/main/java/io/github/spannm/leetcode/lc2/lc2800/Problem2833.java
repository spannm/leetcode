package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2833. Furthest Point From Origin.
 */
class Problem2833 extends LeetcodeProblem {

    int furthestDistanceFromOrigin(String moves) {
        return Math.abs(count(moves, 'L') - count(moves, 'R')) + count(moves, '_');
    }

    private int count(String s, char c) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cnt++;
            }
        }
        return cnt;
    }

}
