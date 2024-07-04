package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix.
 */
class Problem1284 extends LeetcodeProblem {

    int minFlips(int[][] _mat) {
        int nbRows = _mat.length;
        int nbCols = _mat[0].length;
        int state = 0;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_mat[r][c] == 1) {
                    state |= 1 << r * nbCols + c;
                }
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(state);
        Set<Integer> vis = new HashSet<>();
        vis.add(state);
        int ans = 0;
        int[] dirs = {0, -1, 0, 1, 0, 0};
        while (!q.isEmpty()) {
            for (int t = q.size(); t > 0; t--) {
                state = q.poll();
                if (state == 0) {
                    return ans;
                }
                for (int i = 0; i < nbRows; i++) {
                    for (int j = 0; j < nbCols; j++) {
                        int nxt = state;
                        for (int k = 0; k < 5; k++) {
                            int x = i + dirs[k];
                            int y = j + dirs[k + 1];
                            if (x < 0 || x >= nbRows || y < 0 || y >= nbCols) {
                                continue;
                            }
                            if ((nxt & 1 << x * nbCols + y) != 0) {
                                nxt -= 1 << x * nbCols + y;
                            } else {
                                nxt |= 1 << x * nbCols + y;
                            }
                        }
                        if (!vis.contains(nxt)) {
                            vis.add(nxt);
                            q.offer(nxt);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}
