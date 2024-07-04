package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1222. Queens That Can Attack the King.
 */
class Problem1222 extends LeetcodeProblem {

    List<List<Integer>> queensAttacktheKing(int[][] _queens, int[] _king) {
        final int n = 8;
        var s = new boolean[n][n];
        for (var q : _queens) {
            s[q[0]][q[1]] = true;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
                if (a != 0 || b != 0) {
                    int x = _king[0] + a;
                    int y = _king[1] + b;
                    while (x >= 0 && x < n && y >= 0 && y < n) {
                        if (s[x][y]) {
                            ans.add(List.of(x, y));
                            break;
                        }
                        x += a;
                        y += b;
                    }
                }
            }
        }
        return ans;
    }

}
