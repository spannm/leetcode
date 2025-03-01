package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1989. Maximum Number of People That Can Be Caught in Tag.
 */
class Problem1989 extends LeetcodeProblem {

    int catchMaximumAmountofPeople(int[] team, int dist) {
        int ans = 0;
        int n = team.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (team[i] == 1) {
                while (j < n && (team[j] == 1 || i - j > dist)) {
                    j++;
                }
                if (j < n && Math.abs(i - j) <= dist) {
                    ans++;
                    j++;
                }
            }
        }
        return ans;
    }

}
