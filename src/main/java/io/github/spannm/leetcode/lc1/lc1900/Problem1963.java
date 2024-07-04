package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1963. Minimum Number of Swaps to Make the String Balanced.
 */
class Problem1963 extends LeetcodeProblem {

    int minSwaps(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                ans++;
            } else if (ans > 0) {
                ans--;
            }
        }
        return ans + 1 >> 1;
    }

}
