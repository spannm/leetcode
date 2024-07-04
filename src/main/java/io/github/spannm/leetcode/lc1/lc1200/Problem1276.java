package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;

/**
 * 1276. Number of Burgers with No Waste of Ingredients.
 */
class Problem1276 extends LeetcodeProblem {

    List<Integer> numOfBurgers(int _tomatoSlices, int _cheeseSlices) {
        int k = 4 * _cheeseSlices - _tomatoSlices;
        int y = k / 2;
        int x = _cheeseSlices - y;
        return k % 2 != 0 || y < 0 || x < 0 ? List.of() : Arrays.asList(x, y);
    }

}
