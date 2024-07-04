package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 810. Chalkboard XOR Game.
 */
class Problem0810 extends LeetcodeProblem {

    boolean xorGame(int[] _nums) {
        return _nums.length % 2 == 0 || Arrays.stream(_nums).reduce(0, (a, b) -> a ^ b) == 0;
    }

}
