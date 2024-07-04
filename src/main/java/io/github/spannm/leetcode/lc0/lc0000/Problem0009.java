package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * Palindrome Number
 * <p>
 * An integer is a palindrome when it reads the same forward and backward.
 */
class Problem0009 extends LeetcodeProblem {

    boolean isPalindrome(int _x) {
        if (_x < 0) {
            return false;
        } else if (_x < 10) {
            return true;
        }
        char[] arr = String.valueOf(_x).toCharArray();
        int len = arr.length;
        int halflen = len / 2;
        for (int i = 0; i < halflen; i++) {
            if (arr[i] != arr[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
