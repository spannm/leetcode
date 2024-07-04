package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1806 extends LeetcodeProblem {

    int reinitializePermutation(int _n) {
        int[] initial = new int[_n];
        int[] perm = new int[_n];
        for (int i = 0; i < _n; i++) {
            initial[i] = i;
            perm[i] = i;
        }
        int[] arr = new int[_n];
        int times = 0;
        do {
            for (int i = 0; i < _n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[_n / 2 + (i - 1) / 2];
                }
            }
            times++;
            System.arraycopy(arr, 0, perm, 0, _n);
        } while (!Arrays.equals(arr, initial));
        return times;
    }

}
