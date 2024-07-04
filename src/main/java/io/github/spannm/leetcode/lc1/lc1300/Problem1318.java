package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/">1318. Minimum Flips to Make a OR b
 * Equal to c</a>.
 */
class Problem1318 extends LeetcodeProblem {

    int minFlips(int _a, int _b, int _c) {
        int count = 0;
        while (_a > 0 || _b > 0 || _c > 0) {
            if ((_c & 1) == 1) {
                if ((_a & 1) == 0 && (_b & 1) == 0) {
                    count++;
                }
            } else {
                if ((_a & 1) == 1) {
                    count++;
                }
                if ((_b & 1) == 1) {
                    count++;
                }
            }
            _a >>= 1;
            _b >>= 1;
            _c >>= 1;
        }
        return count;
    }

}
