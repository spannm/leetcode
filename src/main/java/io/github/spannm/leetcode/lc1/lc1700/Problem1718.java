package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1718 extends LeetcodeProblem {

    int[] constructDistancedSequence(int _n) {
        int[] result = new int[_n * 2 - 1];
        backtrack(0, result, new boolean[_n + 1], _n);
        return result;
    }

    private static boolean backtrack(int _index, int[] _result, boolean[] _visited, int _n) {
        if (_index == _result.length) {
            return true;
        } else if (_result[_index] != 0) {
            return backtrack(_index + 1, _result, _visited, _n);
        } else {
            for (int i = _n; i > 0; i--) {
                if (_visited[i]) {
                    continue;
                }
                _visited[i] = true;
                _result[_index] = i;
                if (i == 1) {
                    if (backtrack(_index + 1, _result, _visited, _n)) {
                        return true;
                    }
                } else if (_index + i < _result.length && _result[_index + i] == 0) {
                    _result[i + _index] = i;
                    if (backtrack(_index + 1, _result, _visited, _n)) {
                        return true;
                    }
                    _result[_index + i] = 0;
                }
                _result[_index] = 0;
                _visited[i] = false;
            }
        }
        return false;
    }

}
