package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/">2849. Determine if a Cell
 * Is Reachable at a Given Time</a>.
 */
class Problem2849 extends LeetcodeProblem {

    boolean isReachableAtTime(int _sx, int _sy, int _fx, int _fy, int _secs) {
        return !(_sx == _fx && _sy == _fy && _secs == 1)
            && Math.max(Math.abs(_sx - _fx), Math.abs(_sy - _fy)) <= _secs;
    }

}
