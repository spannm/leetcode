package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2079 extends LeetcodeProblem {

    int wateringPlants(int[] _plants, int _capacity) {
        int steps = 0;
        int remainder = _capacity;
        for (int i = 0; i < _plants.length; i++) {
            if (_plants[i] > remainder) {
                steps += i * 2;
                steps++;
                remainder = _capacity - _plants[i];
            } else {
                remainder -= _plants[i];
                steps++;
            }
        }
        return steps;
    }

}
