package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0475 extends LeetcodeProblem {

    int findRadius(int[] _houses, int[] _heaters) {
        Arrays.sort(_heaters);
        int radius = Integer.MIN_VALUE;
        for (int house : _houses) {
            int index = Arrays.binarySearch(_heaters, house);
            if (index < 0) {
                index = ~index;
            }
            int dist1 = index - 1 >= 0 ? house - _heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < _heaters.length ? _heaters[index] - house : Integer.MAX_VALUE;

            radius = Math.max(radius, Math.min(dist1, dist2));
        }
        return radius;
    }

}
