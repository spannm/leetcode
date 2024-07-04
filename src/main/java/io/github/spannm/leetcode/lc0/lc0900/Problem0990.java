package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * 990. Satisfiability of Equality Equations.
 */
class Problem0990 extends LeetcodeProblem {

    boolean equationsPossible(String[] _equations) {
        int[] p = IntStream.range(0, 26).toArray();
        for (String eq : _equations) {
            int a = eq.charAt(0) - 'a';
            int b = eq.charAt(3) - 'a';
            if ('=' == eq.charAt(1)) {
                p[find(a, p)] = find(b, p);
            }
        }
        for (String eq : _equations) {
            int a = eq.charAt(0) - 'a';
            int b = eq.charAt(3) - 'a';
            if ('!' == eq.charAt(1) && find(a, p) == find(b, p)) {
                return false;
            }
        }
        return true;
    }

    static int find(int _x, int[] _arr) {
        if (_arr[_x] != _x) {
            _arr[_x] = find(_arr[_x], _arr);
        }
        return _arr[_x];
    }

}
