package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0254 extends LeetcodeProblem {

    List<List<Integer>> getFactors(int _n) {
        return helper(new ArrayList<>(), new ArrayList<>(), _n, 2);
    }

    static List<List<Integer>> helper(List<List<Integer>> _result, List<Integer> _item, int _n, int _start) {
        if (_n <= 1) {
            if (_item.size() > 1) {
                _result.add(new ArrayList<>(_item));
            }
        } else {
            for (int i = _start; i <= _n; i++) {
                if (_n % i == 0) {
                    _item.add(i);
                    helper(_result, _item, _n / i, i);
                    _item.remove(_item.size() - 1);
                }
            }
        }

        return _result;
    }

}
