package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0216 extends LeetcodeProblem {

    List<List<Integer>> combinationSum3(int _k, int _sum) {
        return backtrack(_k, _sum, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, new ArrayList<>(), new ArrayList<>());
    }

    static List<List<Integer>> backtrack(int _k, int _sum, int[] _nums, int _start, List<Integer> _curr, List<List<Integer>> _result) {
        if (_sum > 0) {
            for (int i = _start; i < _nums.length; i++) {
                _curr.add(_nums[i]);
                backtrack(_k, _sum - _nums[i], _nums, i + 1, _curr, _result);
                _curr.remove(_curr.size() - 1);
            }
        } else if (_sum == 0 && _curr.size() == _k) {
            _result.add(new ArrayList<>(_curr));
        }
        return _result;
    }

}
