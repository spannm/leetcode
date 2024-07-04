package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0202 extends LeetcodeProblem {

    boolean isHappy(int _n) {
        if (_n == 1) {
            return true;
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(_n);
        int result = 0;
        while (result != 1) {
            result = calcResult(_n);
            if (seen.contains(result)) {
                return false;
            }
            seen.add(result);
            _n = result;
        }
        return true;
    }

    static int calcResult(int _num) {
        int result = 0;
        while (_num != 0) {
            result += _num % 10 * (_num % 10);
            _num /= 10;
        }
        return result;
    }

}
