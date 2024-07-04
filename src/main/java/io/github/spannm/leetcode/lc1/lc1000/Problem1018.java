package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1018 extends LeetcodeProblem {

    List<Boolean> prefixesDivBy5(int[] _arr) {
        List<Boolean> result = new ArrayList<>(_arr.length);
        int remainder = 0;
        for (int a : _arr) {
            remainder = ((remainder << 1) + a) % 5;
            result.add(remainder == 0);
        }
        return result;
    }

}
