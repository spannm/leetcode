package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem2279 extends LeetcodeProblem {

    int maximumBags(int[] _capacity, int[] _rocks, int _additionalRocks) {
        int[] delta = new int[_capacity.length];
        int ans = 0;
        for (int i = 0; i < _capacity.length; i++) {
            if (_capacity[i] == _rocks[i]) {
                ans++;
            } else {
                delta[i] = _capacity[i] - _rocks[i];
            }
        }
        Arrays.sort(delta);
        for (int i = 0; i < _capacity.length; i++) {
            if (delta[i] != 0) {
                if (_additionalRocks >= delta[i]) {
                    ans++;
                    _additionalRocks -= delta[i];
                }
            }
        }
        return ans;
    }

}
