package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/permutations-ii/">47. Permutations II</a>.
 */
class Problem0047 extends LeetcodeProblem {

    List<List<Integer>> permuteUnique(int[] _nums) {
        Arrays.sort(_nums);
        Set<List<Integer>> set = new LinkedHashSet<>();
        set.add(new ArrayList<>());
        set = recurse(_nums, set, 0);
        return set.stream().toList();
    }

    private static Set<List<Integer>> recurse(int[] _nums, Set<List<Integer>> _set, int _pos) {
        if (_pos == _nums.length) {
            return _set;
        }
        Set<List<Integer>> newSet = new HashSet<>();
        for (List<Integer> list : _set) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i, _nums[_pos]);
                newSet.add(newList);
            }
        }
        return recurse(_nums, newSet, _pos + 1);
    }

}
