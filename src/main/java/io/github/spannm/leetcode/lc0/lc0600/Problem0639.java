package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 639. Decode Ways II.
 */
public class Problem0639 extends LeetcodeProblem {

    int numDecodings(String _s) {
        final int mod = 1000000007;
        int len = _s.length();
        char[] arr = _s.toCharArray();

        long a = 0;
        long b = 1;
        long c = 0;
        for (int i = 1; i <= len; i++) {

            if (arr[i - 1] == '*') {
                c = 9 * b % mod;
            } else if (arr[i - 1] != '0') {
                c = b;
            } else {
                c = 0;
            }

            if (i > 1) {
                if (arr[i - 2] == '*' && arr[i - 1] == '*') {
                    c = (c + 15 * a) % mod;
                } else if (arr[i - 2] == '*') {
                    if (arr[i - 1] > '6') {
                        c = (c + a) % mod;
                    } else {
                        c = (c + 2 * a) % mod;
                    }
                } else if (arr[i - 1] == '*') {
                    if (arr[i - 2] == '1') {
                        c = (c + 9 * a) % mod;
                    } else if (arr[i - 2] == '2') {
                        c = (c + 6 * a) % mod;
                    }
                } else if (arr[i - 2] != '0' && (arr[i - 2] - '0') * 10 + arr[i - 1] - '0' <= 26) {
                    c = (c + a) % mod;
                }
            }

            a = b;
            b = c;
        }

        return (int) c;
    }

}
