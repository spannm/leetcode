package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0492 extends LeetcodeProblem {

    int[] constructRectangle(int _area) {
        int i = 0;
        int j = _area;
        int[] result = new int[2];
        while (i <= j) {
            long product = (long) i * j;
            if (product == _area) {
                result[0] = j--;
                result[1] = i++;
            } else if (product > _area) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

}
