package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2212. Maximum Points in an Archery Competition.
 */
class Problem2212 extends LeetcodeProblem {

    int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int mx = -1;
        int state = 0;
        for (int mask = 1; mask < 1 << n; ++mask) {
            int cnt = 0;
            int points = 0;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    cnt += aliceArrows[i] + 1;
                    points += i;
                }
            }
            if (cnt <= numArrows && mx < points) {
                state = mask;
                mx = points;
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if ((state >> i & 1) == 1) {
                ans[i] = aliceArrows[i] + 1;
                numArrows -= ans[i];
            }
        }
        ans[0] += numArrows;
        return ans;
    }

}
