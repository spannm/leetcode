package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 587. Erect the Fence.
 */
class Problem0587 extends LeetcodeProblem {

    int[][] outerTrees(int[][] _trees) {
        int nbTrees = _trees.length;
        if (nbTrees < 4) {
            return _trees;
        }
        Arrays.sort(_trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        boolean[] vis = new boolean[nbTrees];
        int[] stk = new int[nbTrees + 10];
        int cnt = 1;
        for (int i = 1; i < nbTrees; i++) {
            while (cnt > 1 && cross(_trees[stk[cnt - 1]], _trees[stk[cnt - 2]], _trees[i]) < 0) {
                vis[stk[--cnt]] = false;
            }
            vis[i] = true;
            stk[cnt++] = i;
        }
        int m = cnt;
        for (int i = nbTrees - 1; i >= 0; i--) {
            if (vis[i]) {
                continue;
            }
            while (cnt > m && cross(_trees[stk[cnt - 1]], _trees[stk[cnt - 2]], _trees[i]) < 0) {
                cnt--;
            }
            stk[cnt++] = i;
        }
        int[][] ans = new int[cnt - 1][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = _trees[stk[i]];
        }
        return ans;
    }

    static int cross(int[] _a, int[] _b, int[] _c) {
        return (_b[0] - _a[0]) * (_c[1] - _b[1]) - (_b[1] - _a[1]) * (_c[0] - _b[0]);
    }

}
