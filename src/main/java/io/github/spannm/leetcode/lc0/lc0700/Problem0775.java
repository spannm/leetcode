package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0775 extends LeetcodeProblem {

    boolean isIdealPermutation(int[] _arr) {
        for (int i = 0; i < _arr.length; i++) {
            for (int j = i + 2; j < _arr.length; j++) {
                if (_arr[i] > _arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
