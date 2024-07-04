package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2937. Make Three Strings Equal.
 */
class Problem2937 extends LeetcodeProblem {

    int findMinimumOperations(String s1, String s2, String s3) {
        int s = s1.length() + s2.length() + s3.length();
        int n = Math.min(Math.min(s1.length(), s2.length()), s3.length());
        for (int i = 0; i < n; i++) {
            if (!(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i))) {
                return i == 0 ? -1 : s - 3 * i;
            }
        }
        return s - 3 * n;
    }

}
