package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1996 extends LeetcodeProblem {

    int numberOfWeakCharacters(int[][] _properties) {
        int count = 0;
        Arrays.sort(_properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int max = 0;
        for (int[] property : _properties) {
            count += max > property[1] ? 1 : 0;
            max = Math.max(max, property[1]);
        }
        return count;
    }

}
