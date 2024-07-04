package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0089 extends LeetcodeProblem {

    List<Integer> grayCode(int _n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << _n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }

}
