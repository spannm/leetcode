package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1529. Minimum Suffix Flips.
 */
class Problem1529 extends LeetcodeProblem {

    int minFlips(String target) {
        int ans = 0;
        for (int i = 0; i < target.length(); i++) {
            int v = target.charAt(i) - '0';
            if ((ans & 1 ^ v) != 0) {
                ans++;
            }
        }
        return ans;
    }

}
