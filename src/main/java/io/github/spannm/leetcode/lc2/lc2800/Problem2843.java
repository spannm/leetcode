package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2843. Count Symmetric Integers.
 */
class Problem2843 extends LeetcodeProblem {

    int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int x = low; x <= high; x++) {
            ans += f(x);
        }
        return ans;
    }

    private int f(int x) {
        String s = "" + x;
        int n = s.length();
        if (n % 2 == 1) {
            return 0;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < n / 2; i++) {
            a += s.charAt(i) - '0';
        }
        for (int i = n / 2; i < n; i++) {
            b += s.charAt(i) - '0';
        }
        return a == b ? 1 : 0;
    }

}
