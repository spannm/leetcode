package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1253. Reconstruct a 2-Row Binary Matrix.
 */
class Problem1253 extends LeetcodeProblem {

    List<List<Integer>> reconstructMatrix(int _upper, int _lower, int[] _colsum) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (int i : _colsum) {
            int a = 0;
            int b = 0;
            if (i == 2) {
                a = b = 1;
                _upper--;
                _lower--;
            } else if (i == 1) {
                if (_upper > _lower) {
                    _upper--;
                    a = 1;
                } else {
                    _lower--;
                    b = 1;
                }
            }
            if (_upper < 0 || _lower < 0) {
                break;
            }
            first.add(a);
            second.add(b);
        }
        return _upper == 0 && _lower == 0 ? List.of(first, second) : List.of();
    }

}
