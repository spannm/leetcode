package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;

/**
 * 1301. Number of Paths with Max Score.
 */
class Problem1301 extends LeetcodeProblem {

    private List<String> board;
    private int          sz;
    private int[][]      f;
    private int[][]      g;
    private final int    mod = (int) 1e9 + 7;

    int[] pathsWithMaxScore(List<String> _board) {
        board = _board;
        sz = _board.size();
        f = new int[sz][sz];
        g = new int[sz][sz];
        for (var e : f) {
            Arrays.fill(e, -1);
        }
        f[sz - 1][sz - 1] = 0;
        g[sz - 1][sz - 1] = 1;
        for (int i = sz - 1; i >= 0; i--) {
            for (int j = sz - 1; j >= 0; j--) {
                update(i, j, i + 1, j);
                update(i, j, i, j + 1);
                update(i, j, i + 1, j + 1);
                if (f[i][j] != -1) {
                    char c = _board.get(i).charAt(j);
                    if (c >= '0' && c <= '9') {
                        f[i][j] += c - '0';
                    }
                }
            }
        }
        int[] ans = new int[2];
        if (f[0][0] != -1) {
            ans[0] = f[0][0];
            ans[1] = g[0][0];
        }
        return ans;
    }

    private void update(int i, int j, int x, int y) {
        if (x >= sz || y >= sz || f[x][y] == -1 || board.get(i).charAt(j) == 'X'
            || board.get(i).charAt(j) == 'S') {
            return;
        }
        if (f[x][y] > f[i][j]) {
            f[i][j] = f[x][y];
            g[i][j] = g[x][y];
        } else if (f[x][y] == f[i][j]) {
            g[i][j] = (g[i][j] + g[x][y]) % mod;
        }
    }

}
