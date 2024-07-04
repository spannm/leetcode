package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 2463. Minimum Total Distance Traveled.
 */
class Problem2463 extends LeetcodeProblem {

    private List<Integer> robot;
    private int[][]       factory;
    private long[][]      f;

    long minimumTotalDistance(List<Integer> _robot, int[][] _factory) {
        robot = _robot;
        factory = _factory;
        Collections.sort(_robot);
        Arrays.sort(_factory, Comparator.comparingInt(a -> a[0]));
        f = new long[_robot.size()][_factory.length];
        return dfs(0, 0);
    }

    long dfs(int i, int j) {
        if (i == robot.size()) {
            return 0;
        }
        if (j == factory.length) {
            return Long.MAX_VALUE / 1000;
        }
        if (f[i][j] != 0) {
            return f[i][j];
        }
        long ans = dfs(i, j + 1);
        long t = 0;
        for (int k = 0; k < factory[j][1]; k++) {
            if (i + k == robot.size()) {
                break;
            }
            t += Math.abs(robot.get(i + k) - factory[j][0]);
            ans = Math.min(ans, t + dfs(i + k + 1, j + 1));
        }
        f[i][j] = ans;
        return ans;
    }

}
