package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1387 extends LeetcodeProblem {

    int getKth(int _lo, int _hi, int _k) {
        List<int[]> power = new ArrayList<>();
        for (int i = _lo; i <= _hi; i++) {
            power.add(new int[] {getSteps(i), i});
        }
        power.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return power.get(_k - 1)[1];
    }

    private int getSteps(int _number) {
        int steps = 0;
        while (_number != 1) {
            if (_number % 2 == 0) {
                _number /= 2;
            } else {
                _number = 3 * _number + 1;
            }
            steps++;
        }
        return steps;
    }

}
