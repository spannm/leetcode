package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1538. Guess the Majority in a Hidden Array.
 */
class Problem1538 extends LeetcodeProblem {

    int guessMajority(ArrayReader _reader) {
        int n = _reader.length();
        int x = _reader.query(0, 1, 2, 3);
        int a = 1;
        int b = 0;
        int k = 0;
        for (int i = 4; i < n; i++) {
            if (_reader.query(0, 1, 2, i) == x) {
                a++;
            } else {
                b++;
                k = i;
            }
        }

        int y = _reader.query(0, 1, 2, 4);
        if (_reader.query(1, 2, 3, 4) == y) {
            a++;
        } else {
            b++;
            k = 0;
        }
        if (_reader.query(0, 2, 3, 4) == y) {
            a++;
        } else {
            b++;
            k = 1;
        }
        if (_reader.query(0, 1, 3, 4) == y) {
            a++;
        } else {
            b++;
            k = 2;
        }
        if (a == b) {
            return -1;
        }
        return a > b ? 3 : k;
    }

    abstract static class ArrayReader {
        abstract int length();
        abstract int query(int _i, int _i2, int _i3, int _i4);
    }

}
