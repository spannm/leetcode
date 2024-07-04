package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1442. Count Triplets That Can Form Two Arrays of Equal XOR.
 */
class Problem1442 extends LeetcodeProblem {

    int countTriplets(int[] _arr) {
        int len = _arr.length;
        int[] pre = new int[len + 1];
        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] ^ _arr[i];
        }

        int result = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j; k < len; k++) {
                    int a = pre[j] ^ pre[i];
                    int b = pre[k + 1] ^ pre[j];
                    if (a == b) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
