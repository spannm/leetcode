package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1213 extends LeetcodeProblem {

    List<Integer> arraysIntersection(int[] _arr1, int[] _arr2, int[] _arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < _arr1.length && j < _arr2.length && k < _arr3.length) {
            if (_arr1[i] == _arr2[j] && _arr1[i] == _arr3[k]) {
                result.add(_arr1[i]);
                i++;
                j++;
                k++;
            } else if (_arr1[i] < _arr2[j]) {
                i++;
            } else if (_arr2[j] < _arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }

}
