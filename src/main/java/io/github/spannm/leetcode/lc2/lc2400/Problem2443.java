package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2443. Sum of Number and Its Reverse.
 */
class Problem2443 extends LeetcodeProblem {

    boolean sumOfNumberAndReverse(int num) {
        for (int x = 0; x <= num; x++) {
            int k = x;
            int y = 0;
            while (k > 0) {
                y = y * 10 + k % 10;
                k /= 10;
            }
            if (x + y == num) {
                return true;
            }
        }
        return false;
    }

}
