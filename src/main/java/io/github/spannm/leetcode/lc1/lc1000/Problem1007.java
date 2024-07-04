package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1007. Minimum Domino Rotations For Equal Row.
 */
class Problem1007 extends LeetcodeProblem {

    private int   n;
    private int[] tops;
    private int[] bottoms;

    int minDominoRotations(int[] _tops, int[] _bottoms) {
        n = _tops.length;
        tops = _tops;
        bottoms = _bottoms;
        int ans = Math.min(f(_tops[0]), f(_bottoms[0]));
        return ans > n ? -1 : ans;
    }

    private int f(int _x) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != _x && bottoms[i] != _x) {
                return n + 1;
            }
            cnt1 += tops[i] == _x ? 1 : 0;
            cnt2 += bottoms[i] == _x ? 1 : 0;
        }
        return n - Math.max(cnt1, cnt2);
    }

}
