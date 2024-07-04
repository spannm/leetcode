package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">989. Add to Array-Form of Integer</a>.
 */
class Problem0989 extends LeetcodeProblem {

    List<Integer> addToArrayForm(int[] _num, int _k) {
        int len = _num.length;
        List<Integer> list = new LinkedList<>();
        int idx = len - 1;

        while (idx >= 0 || _k != 0) {
            if (idx >= 0) {
                _k += _num[idx--];
            }

            list.add(0, _k % 10); // modulo
            _k /= 10; // carry
        }

        return list;
    }

}
