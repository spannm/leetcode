package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">39. Combination Sum</a>.
 */
class Problem0039 extends LeetcodeProblem {

    List<List<Integer>> combinationSum(int[] _candidates, int _target) {
        return backtrack(_candidates, _target, 0, new ArrayList<>(), new ArrayList<>());
    }

    static List<List<Integer>> backtrack(int[] _candidates, int _target, int _start, List<List<Integer>> _result, List<Integer> _curr) {
        if (_target == 0) {
            _result.add(new ArrayList<>(_curr));
        } else {
            for (int i = _start; i < _candidates.length; i++) {
                if (_candidates[i] <= _target) {
                    _curr.add(_candidates[i]);
                    backtrack(_candidates, _target - _candidates[i], i, _result, _curr);
                    _curr.remove(_curr.size() - 1);
                }
            }
        }
        return _result;
    }

}
