package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/power-of-two/">231. Power of Two</a>.
 */
class Problem0231 extends LeetcodeProblem {

    boolean isPowerOfTwo(int _n) {
        if (_n <= 0) {
            return false;
        }
        int prev = _n - 1;
        // The bitwise AND (&) operator returns a number or BigInt whose binary representation
        // has a 1 in each bit position for which the corresponding bits of both operands are 1
        return _n > 0 && (_n & prev) == 0; // bitwise AND
    }

    boolean isPowerOfTwo2(int _n) {
        if (_n <= 0) {
            return false;
        }
        while (_n > 2) {
            if (_n % 2 != 0) {
                return false;
            }
            _n /= 2;
        }
        return true;
    }

    boolean isPowerOfTwo3(int _n) {
        // a power of two in binary form has and only has one "1"
        return _n > 0 && Integer.bitCount(_n) == 1;
    }

}
