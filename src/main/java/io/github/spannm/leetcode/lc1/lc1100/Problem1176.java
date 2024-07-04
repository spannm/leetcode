package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1176 extends LeetcodeProblem {

    int dietPlanPerformance(int[] _calories, int _k, int _lower, int _upper) {
        int sum = 0;
        int points = 0;
        for (int i = 0, j = 0; i <= _calories.length - _k && j < _calories.length; j++) {
            sum += _calories[j];
            if (j - i > _k - 1) {
                sum -= _calories[i++];
            }
            if (j - i == _k - 1) {
                if (sum > _upper) {
                    points++;
                } else if (sum < _lower) {
                    points--;
                }
            }
        }
        return points;
    }

}
