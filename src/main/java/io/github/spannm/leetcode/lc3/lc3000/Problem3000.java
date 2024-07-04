package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3000. Maximum Area of Longest Diagonal Rectangle.
 */
class Problem3000 extends LeetcodeProblem {

    int areaOfMaxDiagonal(int[][] _dimensions) {
        int ans = 0;
        int mx = 0;
        for (int[] d : _dimensions) {
            int l = d[0];
            int w = d[1];
            int t = l * l + w * w;
            if (mx < t) {
                mx = t;
                ans = l * w;
            } else if (mx == t) {
                ans = Math.max(ans, l * w);
            }
        }
        return ans;
    }

}
