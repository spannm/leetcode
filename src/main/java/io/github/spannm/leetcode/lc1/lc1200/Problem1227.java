package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1227. Airplane Seat Assignment Probability.
 */
class Problem1227 extends LeetcodeProblem {

    double nthPersonGetsNthSeat(int _n) {
        return _n == 1 ? 1 : .5;
    }

}
