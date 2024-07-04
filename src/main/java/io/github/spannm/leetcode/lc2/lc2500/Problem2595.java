package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2595 extends LeetcodeProblem {

    int[] evenOddBit(int _n) {
        String str = Integer.toBinaryString(_n);
        String reverse = new StringBuilder(str).reverse().toString();
        int even = 0;
        int odd = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                if (reverse.charAt(i) == '1') {
                    even++;
                }
            } else {
                if (reverse.charAt(i) == '1') {
                    odd++;
                }
            }
        }
        return new int[] {even, odd};
    }

}
