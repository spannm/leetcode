package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/">1376. Time Needed to Inform All
 * Employees</a>.
 */
class Problem1376 extends LeetcodeProblem {

    int numOfMinutes(final int _count, final int _headId, final int[] _managers, final int[] _times) {
        int max = 0;
        for (int id = 0; id < _count; id++) {
            if (_times[id] > 0) {
                max = Math.max(max, dfs(id, _managers, _times));
            }
        }
        return max;
    }

    static int dfs(final int _id, final int[] _managers, final int[] _times) {
        if (_managers[_id] != -1) {
            _times[_id] += dfs(_managers[_id], _managers, _times);
            _managers[_id] = -1; // Acting like dp to not traverse again
        }
        return _times[_id];
    }

}
