package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0961 extends LeetcodeProblem {

    int repeatedNTimes(int[] _arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : _arr) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

}
