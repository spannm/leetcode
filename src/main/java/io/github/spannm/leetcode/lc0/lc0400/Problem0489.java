package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Robot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 489. Robot Room Cleaner.
 */
class Problem0489 extends LeetcodeProblem {

    private static final int[] DIRS = {-1, 0, 1, 0, -1};

    void cleanRoom(Robot _robot) {
        dfs(0, 0, 0, _robot, new HashSet<>());
    }

    static void dfs(int _i, int _j, int _d, Robot _robot, Set<List<Integer>> _vis) {
        _robot.clean();
        _vis.add(List.of(_i, _j));
        for (int k = 0; k < 4; k++) {
            int nd = (_d + k) % 4;
            int x = _i + DIRS[nd];
            int y = _j + DIRS[nd + 1];
            if (!_vis.contains(List.of(x, y)) && _robot.move()) {
                dfs(x, y, nd, _robot, _vis);
                _robot.turnRight();
                _robot.turnRight();
                _robot.move();
                _robot.turnRight();
                _robot.turnRight();
            }
            _robot.turnRight();
        }
    }

}
