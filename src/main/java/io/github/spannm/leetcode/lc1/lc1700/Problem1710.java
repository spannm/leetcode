package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1710 extends LeetcodeProblem {

    int maximumUnits(int[][] _boxTypes, int _truckSize) {
        Arrays.sort(_boxTypes, (a, b) -> b[1] - a[1]);
        int totalUnits = 0;
        int loadedBoxes = 0;
        for (int[] boxType : _boxTypes) {
            int number = boxType[0];
            while (loadedBoxes < _truckSize && number > 0) {
                totalUnits += boxType[1];
                number--;
                loadedBoxes++;
            }
        }
        return totalUnits;
    }

}
