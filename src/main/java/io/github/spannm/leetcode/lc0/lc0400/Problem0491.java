package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/non-decreasing-subsequences/">491. Non-decreasing Subsequences</a>.
 */
class Problem0491 extends LeetcodeProblem {

    List<List<Integer>> findSubsequences(int[] _nums) {
        if (_nums == null || _nums.length == 1) {
            return List.of();
        }
        return new ArrayList<>(backtrack(_nums, 0, new ArrayList<>(), new HashSet<>()));
    }

    private static Set<List<Integer>> backtrack(int[] _nums, int _start, List<Integer> _currList, Set<List<Integer>> _answer) {
        if (_currList.size() >= 2) {
            _answer.add(new ArrayList<>(_currList));
        }
        for (int i = _start; i < _nums.length; i++) {
            if (_currList.isEmpty() || _currList.get(_currList.size() - 1) <= _nums[i]) {
                _currList.add(_nums[i]);
                backtrack(_nums, i + 1, _currList, _answer);
                _currList.remove(_currList.size() - 1);
            }
        }
        return _answer;
    }

}
