package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1196 extends LeetcodeProblem {

    int maxNumberOfApples(int[] _arr) {
        Arrays.sort(_arr);
        int sum = 0;
        int i = 0;
        for (; i < _arr.length; i++) {
            sum += _arr[i];
            if (sum > 5000) {
                break;
            }
        }
        return i;
    }

}
