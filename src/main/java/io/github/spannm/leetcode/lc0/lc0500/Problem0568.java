package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0568 extends LeetcodeProblem {

    int maxVacationDays(int[][] _flights, int[][] _days) {
        int[][] memo = new int[_flights.length][_days[0].length];
        for (int[] l : memo) {
            Arrays.fill(l, Integer.MIN_VALUE);
        }
        return dfs(_flights, _days, 0, 0, memo);
    }

    int dfs(int[][] _flights, int[][] _days, int _curCity, int _weekno, int[][] _memo) {
        if (_weekno == _days[0].length) {
            return 0;
        } else if (_memo[_curCity][_weekno] != Integer.MIN_VALUE) {
            return _memo[_curCity][_weekno];
        }
        int maxvac = 0;
        for (int i = 0; i < _flights.length; i++) {
            if (_flights[_curCity][i] == 1 || i == _curCity) {
                int vac = _days[i][_weekno] + dfs(_flights, _days, i, _weekno + 1, _memo);
                maxvac = Math.max(maxvac, vac);
            }
        }
        _memo[_curCity][_weekno] = maxvac;
        return maxvac;
    }

}
