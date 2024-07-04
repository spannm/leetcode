package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0762 extends LeetcodeProblem {

    int countPrimeSetBits(int _l, int _r) {
        int count = 0;
        for (int i = _l; i <= _r; i++) {
            if (hasPrimeNumberSetBits(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasPrimeNumberSetBits(int _num) {
        int k = getSetBits(_num);
        if (k <= 1) {
            return false;
        }
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getSetBits(int _n) {
        int bits = 0;
        while (_n != 0) {
            bits++;
            _n &= _n - 1;
        }
        return bits;
    }

}
