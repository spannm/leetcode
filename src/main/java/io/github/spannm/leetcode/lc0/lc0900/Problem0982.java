package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 982. Triples with Bitwise AND Equal To Zero.
 */
class Problem0982 extends LeetcodeProblem {

    int countTriplets(int[] _nums) {
        int mx = 0;
        for (int x : _nums) {
            mx = Math.max(mx, x);
        }
        int[] cnt = new int[mx + 1];
        for (int x : _nums) {
            for (int y : _nums) {
                cnt[x & y]++;
            }
        }
        int ans = 0;
        for (int xy = 0; xy <= mx; xy++) {
            for (int z : _nums) {
                if ((xy & z) == 0) {
                    ans += cnt[xy];
                }
            }
        }
        return ans;
    }

}
