package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2952. Minimum Number of Coins to be Added.
 */
class Problem2952 extends LeetcodeProblem {

    int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0;
        for (int i = 0, s = 1; s <= target;) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i++];
            } else {
                s <<= 1;
                ans++;
            }
        }
        return ans;
    }

}
