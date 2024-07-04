package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem2125 extends LeetcodeProblem {

    int numberOfBeams(String[] _floorPlan) {
        int nbFloors = _floorPlan.length;
        if (nbFloors <= 1) {
            return 0;
        }
        int nbBeams = 0;

        for (int idx = 0; idx < nbFloors;) {
            while (idx < nbFloors && _floorPlan[idx].indexOf('1') == -1) {
                idx++;
            }
            if (idx >= nbFloors) {
                break;
            }

            int num1 = 0;
            for (char c : _floorPlan[idx].toCharArray()) {
                if (c == '1') {
                    num1++;
                }
            }
            idx++;
            while (idx < nbFloors && _floorPlan[idx].indexOf('1') == -1) {
                idx++;
            }

            if (idx >= nbFloors) {
                break;
            }
            char[] floor = _floorPlan[idx].toCharArray();
            int num2 = (int) IntStream.range(0, floor.length).filter(i -> floor[i] == '1').count();

            nbBeams += num1 * num2;
        }
        return nbBeams;
    }

}
