package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2303 extends LeetcodeProblem {

    double calculateTax(int[][] _brackets, int _income) {
        double taxes = 0.0;
        int lastUpper = 0;
        for (int[] bracket : _brackets) {
            int upper = bracket[0];
            double percent = bracket[1] / 100.0;
            if (_income > upper) {
                taxes += (upper - lastUpper) * percent;
            } else {
                taxes += (_income - lastUpper) * percent;
                break;
            }
            lastUpper = upper;
        }
        return taxes;
    }

}
