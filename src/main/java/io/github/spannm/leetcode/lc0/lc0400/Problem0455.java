package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0455 extends LeetcodeProblem {

    int findContentChildren(int[] _greed, int[] _size) {
        Arrays.sort(_greed);
        Arrays.sort(_size);

        int result = 0;
        for (int g = 0, s = 0; g < _greed.length && s < _size.length;) {
            if (_greed[g] <= _size[s]) {
                result++;
                g++;
            }
            s++;
        }
        return result;
    }

}
