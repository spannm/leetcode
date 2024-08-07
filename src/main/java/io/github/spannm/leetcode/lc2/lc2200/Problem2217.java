package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2217. Find Palindrome With Fixed Length.
 */
class Problem2217 extends LeetcodeProblem {

    long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ans = new long[n];
        int l = intLength + 1 >> 1;
        long start = (long) Math.pow(10, l - 1);
        long end = (long) Math.pow(10, l) - 1;
        for (int i = 0; i < n; i++) {
            long v = start + queries[i] - 1;
            if (v > end) {
                ans[i] = -1;
                continue;
            }
            String s = "" + v;
            s += new StringBuilder(s).reverse().substring(intLength % 2);
            ans[i] = Long.parseLong(s);
        }
        return ans;
    }

}
