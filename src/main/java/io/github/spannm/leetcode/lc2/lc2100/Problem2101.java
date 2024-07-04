package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/detonate-the-maximum-bombs/">2101. Detonate the Maximum Bombs</a>.
 */
class Problem2101 extends LeetcodeProblem {

    int maximumDetonation(int[][] _bombs) {
        final int bombCount = _bombs.length;
        int res = 0;
        for (int i = 0; i < bombCount; i++) {
            res = Math.max(res, dfs(i, bombCount, _bombs, new boolean[bombCount]));
            if (res == bombCount) { // can detonate all
                return res;
            }
        }
        return res;
    }

    int dfs(int _start, int _bombCount, int[][] _bombs, boolean[] _seen) {
        int count = 1;
        _seen[_start] = true;

        final int x1 = _bombs[_start][0];
        final int y1 = _bombs[_start][1];
        final int rad1 = _bombs[_start][2];

        for (int i = 0; i < _bombCount; i++) {
            if (!_seen[i]) {
                int x2 = _bombs[i][0];
                int y2 = _bombs[i][1];
                if (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) <= rad1) {
                    count += dfs(i, _bombCount, _bombs, _seen);
                }
            }
        }

        return count;
    }

}
