package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">46. Permutations</a>.
 */
class Problem0046 extends LeetcodeProblem {

    List<List<Integer>> permute(int[] _nums) {
        List<Integer> p = new ArrayList<>();
        final List<List<Integer>> result = permute(p, _nums);

        p = null;
        _nums = null;
        System.gc();

        return result;
    }

    static List<List<Integer>> permute(final List<Integer> _p, final int[] _nums) {
        if (_nums.length == 0) {
            List<List<Integer>> sublist = new ArrayList<>();
            sublist.add(_p);
            return sublist;
        }
        int num = _nums[0];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= _p.size(); i++) {
            List<Integer> new1 = new ArrayList<>(_p.subList(0, i));
            new1.add(num);
            new1.addAll(_p.subList(i, _p.size()));
            ans.addAll(permute(new1, Arrays.copyOfRange(_nums, 1, _nums.length)));
        }
        return ans;
    }

}
