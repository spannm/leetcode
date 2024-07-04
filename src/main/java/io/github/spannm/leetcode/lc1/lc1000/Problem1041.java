package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1041. Robot Bounded In Circle.
 */
class Problem1041 extends LeetcodeProblem {

    boolean isRobotBounded(String _instructions) {
        int k = 0;
        int[] dist = new int[4];
        for (int i = 0; i < _instructions.length(); i++) {
            char c = _instructions.charAt(i);
            if (c == 'L') {
                k = (k + 1) % 4;
            } else if (c == 'R') {
                k = (k + 3) % 4;
            } else {
                dist[k]++;
            }
        }
        return dist[0] == dist[2] && dist[1] == dist[3] || k != 0;
    }

}
