package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1780 extends LeetcodeProblem {

    boolean checkPowersOfThree(int _n) {
        List<Integer> powers = new ArrayList<>();
        int power = 1;
        for (int i = 1; power <= _n; i++) {
            powers.add(power);
            power = (int) Math.pow(3, i);
        }
        int i = powers.size() - 1;
        while (_n > 0 && i >= 0) {
            if (_n - powers.get(i) > 0) {
                _n -= powers.get(i--);
            } else if (_n - powers.get(i) == 0) {
                return true;
            } else {
                i--;
            }
        }
        return _n == 0;
    }

}
