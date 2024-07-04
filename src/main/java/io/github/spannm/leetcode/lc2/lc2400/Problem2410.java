package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2410. Maximum Matching of Players With Trainers.
 */
class Problem2410 extends LeetcodeProblem {

    int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        int j = 0;
        for (int p : players) {
            while (j < trainers.length && trainers[j] < p) {
                j++;
            }
            if (j < trainers.length) {
                ans++;
                j++;
            }
        }
        return ans;
    }

}
