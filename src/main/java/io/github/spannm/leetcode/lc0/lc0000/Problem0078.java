package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets.
 */
class Problem0078 extends LeetcodeProblem {

    List<List<Integer>> subsets(int[] _nums) {
        if (_nums == null) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : _nums) {
            List<List<Integer>> temp = new ArrayList<>();

            for (List<Integer> list : result) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                temp.add(newList);
            }
            result.addAll(temp);
        }
        return result;
    }

}
