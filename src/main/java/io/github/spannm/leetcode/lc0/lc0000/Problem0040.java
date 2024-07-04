package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/">40. Combination Sum II</a>.
 */
class Problem0040 extends LeetcodeProblem {

    List<List<Integer>> combinationSum2(int[] _candidates, int _target) {
        Arrays.sort(_candidates);
        return backtrack(_candidates, 0, new ArrayList<>(), _target, new ArrayList<>());
    }

    static List<List<Integer>> backtrack(int[] _candidates, int _start, List<List<Integer>> _result, int _target, List<Integer> _curr) {
        if (_target > 0) {
            for (int i = _start; i < _candidates.length; i++) {
                if (_candidates[i] > _target || i > _start && _candidates[i - 1] == _candidates[i]) {
                    continue;
                }
                _curr.add(_candidates[i]);
                backtrack(_candidates, i + 1, _result, _target - _candidates[i], _curr);
                _curr.remove(_curr.size() - 1);
            }
        } else if (_target == 0) {
            _result.add(new ArrayList<>(_curr));
        }
        return _result;
    }

}
