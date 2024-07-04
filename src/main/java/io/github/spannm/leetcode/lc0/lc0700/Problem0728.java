package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0728 extends LeetcodeProblem {

    List<Integer> selfDividingNumbers(int _left, int _right) {
        List<Integer> result = new ArrayList<>();
        for (int num = _left; num <= _right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private static boolean isSelfDividing(int _num) {
        int tmp = _num;
        while (tmp != 0) {
            int digit = tmp % 10;
            if (digit == 0 || _num % digit != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }

}
