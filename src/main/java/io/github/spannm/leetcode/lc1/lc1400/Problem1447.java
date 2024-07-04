package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1447 extends LeetcodeProblem {

    List<String> simplifiedFractions(int _n) {
        List<String> result = new ArrayList<>();
        for (int denominator = 2; denominator <= _n; denominator++) {
            for (int nominator = 1; nominator < denominator; nominator++) {
                if (getGcd(nominator, denominator) == 1) {
                    result.add(nominator + "/" + denominator);
                }
            }
        }
        return result;
    }

    private int getGcd(int _a, int _b) {
        return _b == 0 ? _a : getGcd(_b, _a % _b);
    }

}
