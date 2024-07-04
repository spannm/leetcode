package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;

class Problem1056 extends LeetcodeProblem {
    private final Map<Integer, Integer> map = Map.of(
        0, 0,
        1, 1,
        8, 8,
        6, 9,
        9, 6);

    boolean confusingNumber(int _n) {
        if (_n == 0) {
            return false;
        }
        int newNumber = 0;
        int originalN = _n;
        while (_n != 0) {
            newNumber *= 10;
            int digit = _n % 10;
            if (!map.containsKey(digit)) {
                return false;
            }
            digit = map.get(digit);
            newNumber += digit;
            _n /= 10;
        }
        return newNumber != originalN;
    }

}
