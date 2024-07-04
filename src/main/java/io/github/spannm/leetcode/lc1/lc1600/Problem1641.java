package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1641 extends LeetcodeProblem {

    int countVowelStrings(int _n) {
        if (_n == 1) {
            return 5;
        }
        int[] arr = new int[] {1, 1, 1, 1, 1};
        int sum = 5;
        for (int i = 2; i <= _n; i++) {
            int[] copy = new int[5];
            for (int j = 0; j < arr.length; j++) {
                if (j == 0) {
                    copy[j] = sum;
                } else {
                    copy[j] = copy[j - 1] - arr[j - 1];
                }
            }
            arr = Arrays.copyOf(copy, 5);
            sum = 0;
            for (int element : arr) {
                sum += element;
            }
        }
        return sum;
    }

}
