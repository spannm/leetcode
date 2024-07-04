package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2525 extends LeetcodeProblem {

    String categorizeBox(int _length, int _width, int _height, int _mass) {
        int dimensionLimit = 10000;
        int volumeLimit = 1000000000;
        boolean isBulky = false;
        long volume = (long) _length * _width * _height;
        if (_length >= dimensionLimit || _width >= dimensionLimit || _height >= dimensionLimit || volume >= volumeLimit) {
            isBulky = true;
        }
        boolean isHeavy = _mass >= 100;
        if (isBulky && isHeavy) {
            return "Both";
        } else if (!isBulky && !isHeavy) {
            return "Neither";
        } else if (isBulky && !isHeavy) {
            return "Bulky";
        } else {
            return "Heavy";
        }
    }

}
