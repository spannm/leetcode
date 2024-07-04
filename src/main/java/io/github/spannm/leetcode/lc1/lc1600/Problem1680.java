package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1680 extends LeetcodeProblem {

    int concatenatedBinary(int _n) {
        final int mod = 1000000007;
        int result = 0;
        for (int i = 1; i <= _n; i++) {
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) {
                result = (result * 2 + binary.charAt(j) - '0') % mod;
            }
        }
        return result;
    }

}
