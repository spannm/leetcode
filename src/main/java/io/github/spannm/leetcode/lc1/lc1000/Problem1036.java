package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 1036. Escape a Large Maze.
 */
class Problem1036 extends LeetcodeProblem {

    private static final int     N       = (int) 1e6;
    private static final int[][] DIRS    = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final Set<Integer>   blocked = new HashSet<>();

    boolean isEscapePossible(int[][] _blocked, int[] _source, int[] _target) {
        blocked.clear();
        for (int[] b : _blocked) {
            blocked.add(b[0] * N + b[1]);
        }
        return dfs(_source, _target, new HashSet<>()) && dfs(_target, _source, new HashSet<>());
    }

    private boolean dfs(int[] _source, int[] _target, Set<Integer> _seen) {
        int sx = _source[0];
        int sy = _source[1];
        int tx = _target[0];
        int ty = _target[1];
        if (sx < 0 || sx >= N || sy < 0 || sy >= N || tx < 0 || tx >= N || ty < 0 || ty >= N
            || blocked.contains(sx * N + sy) || _seen.contains(sx * N + sy)) {
            return false;
        }
        _seen.add(sx * N + sy);
        if (_seen.size() > 20000 || sx == _target[0] && sy == _target[1]) {
            return true;
        }
        for (int[] dir : DIRS) {
            if (dfs(new int[] {sx + dir[0], sy + dir[1]}, _target, _seen)) {
                return true;
            }
        }
        return false;
    }

}
