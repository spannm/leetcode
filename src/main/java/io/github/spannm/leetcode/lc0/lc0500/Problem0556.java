package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0556 extends LeetcodeProblem {

    int nextGreaterElement(int _n) {
        char[] digits = String.valueOf(_n).toCharArray();
        int i = digits.length - 2;
        while (i >= 0 && digits[i + 1] <= digits[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = digits.length - 1;
        while (j >= 0 && digits[j] <= digits[i]) {
            j--;
        }
        swap(digits, i, j);
        reverse(digits, i + 1);
        try {
            return Integer.parseInt(new String(digits));
        } catch (Exception _ex) {
            return -1;
        }
    }

    static void reverse(char[] _a, int _start) {
        int i = _start;
        int j = _a.length - 1;
        while (i < j) {
            swap(_a, i, j);
            i++;
            j--;
        }
    }

    static void swap(char[] _a, int _i, int _j) {
        char tmp = _a[_i];
        _a[_i] = _a[_j];
        _a[_j] = tmp;
    }

}
