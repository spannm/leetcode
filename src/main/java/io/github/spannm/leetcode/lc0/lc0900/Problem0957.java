package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Problem0957 extends LeetcodeProblem {

    int[] prisonAfterNDays(int[] _cells, int _n) {
        Set<String> prisonStates = new HashSet<>();
        boolean hasCycle = false;
        int times = 0;
        for (int i = 0; i < _n; i++) {
            int[] next = getNextDay(_cells);
            String nextDayState = Arrays.toString(next);
            if (prisonStates.contains(nextDayState)) {
                hasCycle = true;
                break;
            } else {
                prisonStates.add(nextDayState);
                times++;
            }
            _cells = next;
        }
        if (hasCycle) {
            _n %= times;
            for (int i = 0; i < _n; i++) {
                _cells = getNextDay(_cells);
            }
        }
        return _cells;
    }

    private int[] getNextDay(int[] _cells) {
        int[] nextDay = new int[_cells.length];
        for (int i = 0; i < _cells.length; i++) {
            if (i == 0 || i == _cells.length - 1) {
                nextDay[i] = 0;
            } else {
                nextDay[i] = _cells[i - 1] == _cells[i + 1] ? 1 : 0;
            }
        }
        return nextDay;
    }

}
