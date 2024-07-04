package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem2133 extends LeetcodeProblem {

    boolean checkValid(int[][] _matrix) {
        int n = _matrix.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int[] value : _matrix) {
            Set<Integer> copy = new HashSet<>(set);
            for (int j = 0; j < n; j++) {
                if (!copy.remove(value[j])) {
                    return false;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            Set<Integer> copy = new HashSet<>(set);
            for (int[] ints : _matrix) {
                if (!copy.remove(ints[j])) {
                    return false;
                }
            }
        }
        return true;
    }

}
