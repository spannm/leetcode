package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combinations/">77. Combinations</a>.
 */
class Problem0077 extends LeetcodeProblem {

    List<List<Integer>> combine(int _n, int _k) {
        if (_k > _n || _k < 0) {
            return List.of();
        } else if (_k == 0) {
            List<List<Integer>> x = new ArrayList<>();
            x.add(new ArrayList<>());
            return x;
        }

        List<List<Integer>> res = combine(_n - 1, _k - 1);
        // if at this point res is empty, it can only be that k-1 == 0,
        // n-1 < k-1 is not possible since n>=k (if n<k, the function would have already returned at an early point)
        for (List<Integer> list : res) {
            list.add(_n);
        }
        res.addAll(combine(_n - 1, _k));
        return res;
    }

}
