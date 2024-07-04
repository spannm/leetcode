package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2957. Remove Adjacent Almost-Equal Characters.
 */
class Problem2957 extends LeetcodeProblem {

    int removeAlmostEqualCharacters(String word) {
        int ans = 0;
        int n = word.length();
        for (int i = 1; i < n; i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) < 2) {
                ans++;
                i++;
            }
        }
        return ans;
    }

}
