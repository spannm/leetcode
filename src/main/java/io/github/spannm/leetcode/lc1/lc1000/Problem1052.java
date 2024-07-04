package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1052. Grumpy Bookstore Owner.
 */
class Problem1052 extends LeetcodeProblem {

    int maxSatisfied(int[] _customers, int[] _grumpy, int _minutes) {
        int s = 0;
        int cs = 0;
        int len = _customers.length;
        for (int i = 0; i < len; i++) {
            s += _customers[i] * _grumpy[i];
            cs += _customers[i];
        }
        int t = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            t += _customers[i] * _grumpy[i];
            int j = i - _minutes + 1;
            if (j >= 0) {
                result = Math.max(result, cs - (s - t));
                t -= _customers[j] * _grumpy[j];
            }
        }
        return result;
    }

}
