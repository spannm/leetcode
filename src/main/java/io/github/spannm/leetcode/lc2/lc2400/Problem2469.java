package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2469 extends LeetcodeProblem {

    double[] convertTemperature(double _celsius) {
        return new double[] {_celsius + 273.15, _celsius * 1.80 + 32.00};
    }

}
