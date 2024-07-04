package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0090 extends LeetcodeProblem {

    List<List<Integer>> subsetsWithDup(int[] _nums) {
        if (_nums == null) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        result.add(empty);
        Arrays.sort(_nums);
        for (int num : _nums) {
            Set<List<Integer>> temp = new HashSet<>();
            for (List<Integer> list : result) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                temp.add(newList);
            }
            result.addAll(temp);
        }

        Set<List<Integer>> resultSet = new LinkedHashSet<>(result);
        result.clear();
        result.addAll(resultSet);
        return result;
    }

}
