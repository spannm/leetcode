package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1794. Count Pairs of Equal Substrings With Minimum Difference.
 */
class Problem1794 extends LeetcodeProblem {

    int countQuadruples(String firstString, String secondString) {
        int[] last = new int[26];
        for (int i = 0; i < secondString.length(); i++) {
            last[secondString.charAt(i) - 'a'] = i + 1;
        }
        int ans = 0;
        int mi = 1 << 30;
        for (int i = 0; i < firstString.length(); i++) {
            int j = last[firstString.charAt(i) - 'a'];
            if (j > 0) {
                int t = i - j;
                if (mi > t) {
                    mi = t;
                    ans = 1;
                } else if (mi == t) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
