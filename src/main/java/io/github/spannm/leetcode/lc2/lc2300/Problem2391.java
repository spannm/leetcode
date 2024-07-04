package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/">2391. Minimum Amount of Time to
 * Collect Garbage</a>.
 */
class Problem2391 extends LeetcodeProblem {

    int garbageCollection(String[] _garbage, int[] _travel) {
        int metal = 0;
        int paper = 0;
        int glass = 0;

        int sum = 0;

        for (int idxHouse = 0; idxHouse < _garbage.length; idxHouse++) {
            String garbage = _garbage[idxHouse];
            int garbageLen = garbage.length();
            sum += garbageLen; // add 1 minute per pick-up
            for (int j = 0; j < garbageLen; j++) {
                char c = garbage.charAt(j);
                if (c == 'P') {
                    paper = idxHouse;
                } else if (c == 'M') {
                    metal = idxHouse;
                } else if (c == 'G') {
                    glass = idxHouse;
                }
            }
        }

        for (int i = 1; i < _travel.length; i++) {
            _travel[i] = _travel[i] + _travel[i - 1];
        }

        if (paper != 0) {
            sum += _travel[paper - 1]; // travel time till last P
        }
        if (metal != 0) {
            sum += _travel[metal - 1]; // travel time till last M
        }
        if (glass != 0) {
            sum += _travel[glass - 1]; // travel time till last G
        }
        return sum;
    }

}
