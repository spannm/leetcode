package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1533. Find the Index of the Large Integer.
 */
class Problem1533 extends LeetcodeProblem {

    int getIndex(ArrayReader _reader) {
        int left = 0;
        int right = _reader.length() - 1;
        while (left < right) {
            int t1 = left;
            int t2 = left + (right - left) / 3;
            int t3 = left + (right - left) / 3 * 2 + 1;
            int cmp = _reader.compareSub(t1, t2, t2 + 1, t3);
            if (cmp == 0) {
                left = t3 + 1;
            } else if (cmp == 1) {
                right = t2;
            } else {
                left = t2 + 1;
                right = t3;
            }
        }
        return left;
    }

    abstract static class ArrayReader {
        abstract int length();
        abstract int compareSub(int _t1, int _t2, int _i, int _t3);
    }

}
