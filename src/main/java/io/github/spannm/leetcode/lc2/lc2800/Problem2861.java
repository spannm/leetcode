package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2861. Maximum Number of Alloys.
 */
class Problem2861 extends LeetcodeProblem {

    int maxNumberOfAlloys(int _nbTypes, int _nbMashines, int _budget, List<List<Integer>> _compo, List<Integer> _stock, List<Integer> _cost) {
        int l = -1;
        int r = _budget / _cost.get(0) + _stock.get(0);
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (isValid(mid, _nbTypes, _budget, _compo, _stock, _cost)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    static boolean isValid(long _target, int _nbTypes, int _budget, List<List<Integer>> _compo, List<Integer> _stock, List<Integer> _cost) {
        for (List<Integer> currMachine : _compo) {
            long remain = _budget;
            for (int j = 0; j < _nbTypes && remain >= 0; j++) {
                long need = Math.max(0, currMachine.get(j) * _target - _stock.get(j));
                remain -= need * _cost.get(j);
            }
            if (remain >= 0) {
                return true;
            }
        }
        return false;
    }

}
