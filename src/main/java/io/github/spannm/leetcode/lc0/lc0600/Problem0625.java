package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0625 extends LeetcodeProblem {

    int smallestFactorization(int _a) {
        if (_a < 10) {
            return _a;
        }

        List<Integer> resultArray = new ArrayList<>();
        for (int i = 9; i > 1; i--) {

            while (_a % i == 0) {
                _a = _a / i;
                resultArray.add(i);
            }
        }

        if (_a != 0) {
            return 0;
        }

        long result = 0;
        for (int i = resultArray.size() - 1; i >= 0; i--) {
            result = result * 10 + resultArray.get(i);
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }

}
