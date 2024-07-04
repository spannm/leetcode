package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.GridMaster;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 1778. Shortest Path in a Hidden Grid.
 */
class Problem1778 extends LeetcodeProblem {

    private static final char[] DIR  = {'U', 'R', 'D', 'L'};
    private static final char[] NDIR = {'D', 'L', 'U', 'R'};
    private static final int[]  DIRS = {-1, 0, 1, 0, -1};
    private static final int    N    = 1010;
    private Set<Integer>        s;
    private int[]               target;

    int findShortestPath(GridMaster _master) {
        target = null;
        s = new HashSet<>();
        s.add(0);
        dfs(0, 0, _master);
        if (target == null) {
            return -1;
        }
        s.remove(0);
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        int ans = -1;
        while (!q.isEmpty()) {
            ans++;
            for (int n = q.size(); n > 0; n--) {
                int[] p = q.poll();
                int i = p[0];
                int j = p[1];
                if (target[0] == i && target[1] == j) {
                    return ans;
                }
                for (int k = 0; k < 4; k++) {
                    int x = i + DIRS[k];
                    int y = j + DIRS[k + 1];
                    if (s.contains(x * N + y)) {
                        s.remove(x * N + y);
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
        return -1;
    }

    private void dfs(int _i, int _j, GridMaster _master) {
        if (_master.isTarget()) {
            target = new int[] {_i, _j};
        }
        for (int k = 0; k < 4; k++) {
            char d = DIR[k];
            char nd = NDIR[k];
            int x = _i + DIRS[k];
            int y = _j + DIRS[k + 1];
            if (_master.canMove(d) && !s.contains(x * N + y)) {
                s.add(x * N + y);
                _master.move(d);
                dfs(x, y, _master);
                _master.move(nd);
            }
        }
    }

}
