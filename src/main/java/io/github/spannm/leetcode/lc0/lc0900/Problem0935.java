package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0935 extends LeetcodeProblem {

    int knightDialer(int _n) {

        final int mod = 1000_000_007;
        final int[][] destinations = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        long[] a = new long[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 0; i < _n - 1; i++) {
            long[] tmp = new long[10];

            for (int j = 0; j < 10; j++) {

                for (int k : destinations[j]) {
                    tmp[j] = (tmp[j] + a[k]) % mod;
                }
            }

            a = tmp;
        }

        long ans = 0;
        for (long k : a) {
            ans = (ans + k) % mod;
        }

        return (int) ans;
    }

}
