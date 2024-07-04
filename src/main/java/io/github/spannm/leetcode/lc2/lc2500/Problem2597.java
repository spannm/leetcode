package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2597. The Number of Beautiful Subsets.
 */
class Problem2597 extends LeetcodeProblem {

    int beautifulSubsets(int[] _nums, int _k) {
        return dfs(0, _nums, _k, -1, new int[1010]);
    }

    static int dfs(int _i, int[] _nums, int _k, int _answer, int[] _cnt) {
        if (_i >= _nums.length) {
            return ++_answer;
        }
        _answer = dfs(_i + 1, _nums, _k, _answer, _cnt);
        boolean ok1 = _nums[_i] + _k >= _cnt.length || _cnt[_nums[_i] + _k] == 0;
        boolean ok2 = _nums[_i] - _k < 0 || _cnt[_nums[_i] - _k] == 0;
        if (ok1 && ok2) {
            _cnt[_nums[_i]]++;
            _answer = dfs(_i + 1, _nums, _k, _answer, _cnt);
            _cnt[_nums[_i]]--;
        }
        return _answer;
    }

}
