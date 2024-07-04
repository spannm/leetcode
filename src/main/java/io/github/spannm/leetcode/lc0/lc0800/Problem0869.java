package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 869. Reordered Power of 2.
 */
class Problem0869 extends LeetcodeProblem {

    boolean reorderedPowerOf2(int _n) {
        String s = convert(_n);
        for (int i = 1; i <= Math.pow(10, 9); i <<= 1) {
            if (s.equals(convert(i))) {
                return true;
            }
        }
        return false;
    }

    static String convert(int _n) {
        char[] cnt = new char[10];
        for (; _n > 0; _n /= 10) {
            cnt[_n % 10]++;
        }
        return new String(cnt);
    }

}
