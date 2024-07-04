package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. Walking Robot Simulation.
 */
class Problem0874 extends LeetcodeProblem {

    int robotSim(int[] _commands, int[][] _obstacles) {
        int[] dirs = {0, 1, 0, -1, 0};
        Set<Integer> s = new HashSet<>(_obstacles.length);
        for (var e : _obstacles) {
            s.add(f(e[0], e[1]));
        }
        int ans = 0;
        int k = 0;
        int x = 0;
        int y = 0;
        for (int c : _commands) {
            if (c == -2) {
                k = (k + 3) % 4;
            } else if (c == -1) {
                k = (k + 1) % 4;
            } else {
                while (c-- > 0) {
                    int nx = x + dirs[k];
                    int ny = y + dirs[k + 1];
                    if (s.contains(f(nx, ny))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    static int f(int _x, int _y) {
        return _x * 60010 + _y;
    }

}
