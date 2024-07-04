package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1342 extends LeetcodeProblem {

    int numberOfSteps(int _num) {
        int steps = 0;
        while (_num != 0) {
            if (_num % 2 == 0) {
                _num /= 2;
            } else {
                _num--;
            }
            steps++;
        }
        return steps;
    }

}
