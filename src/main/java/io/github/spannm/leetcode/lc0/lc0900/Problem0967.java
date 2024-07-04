package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 967. Numbers With Same Consecutive Differences.
 */
class Problem0967 extends LeetcodeProblem {

    int[] numsSameConsecDiff(int _n, int _k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(_n - 1, _k, i, res);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(int _n, int _k, int _t, List<Integer> _res) {
        if (_n == 0) {
            _res.add(_t);
            return;
        }
        int last = _t % 10;
        if (last + _k <= 9) {
            dfs(_n - 1, _k, _t * 10 + last + _k, _res);
        }
        if (last - _k >= 0 && _k != 0) {
            dfs(_n - 1, _k, _t * 10 + last - _k, _res);
        }
    }

}
