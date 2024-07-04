package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 780. Reaching Points.
 */
class Problem0780 extends LeetcodeProblem {

    boolean reachingPoints(int _sx, int _sy, int _tx, int _ty) {
        while (_tx > _sx && _ty > _sy && _tx != _ty) {
            if (_tx > _ty) {
                _tx %= _ty;
            } else {
                _ty %= _tx;
            }
        }
        if (_tx == _sx && _ty == _sy) {
            return true;
        }
        if (_tx == _sx) {
            return _ty > _sy && (_ty - _sy) % _tx == 0;
        }
        if (_ty == _sy) {
            return _tx > _sx && (_tx - _sx) % _ty == 0;
        }
        return false;
    }

}
