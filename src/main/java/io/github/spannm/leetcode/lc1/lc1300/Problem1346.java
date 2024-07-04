package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1346 extends LeetcodeProblem {

    boolean checkIfExist(int[] _arr) {
        for (int i = 0; i < _arr.length; i++) {
            for (int j = 0; j < _arr.length; j++) {
                if (i != j && (_arr[i] * 2 == _arr[j] || _arr[i] == _arr[j] * 2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
