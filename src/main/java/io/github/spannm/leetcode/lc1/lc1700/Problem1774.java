package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1774 extends LeetcodeProblem {
    private int result = 0;

    int closestCost(int[] _baseCosts, int[] _toppingCosts, int _target) {
        result = _baseCosts[0];
        for (int baseCost : _baseCosts) {
            recursion(baseCost, _toppingCosts, 0, _target);
        }
        return result;
    }

    private void recursion(int _currentCost, int[] _toppingCosts, int _index, int _target) {
        if (Math.abs(_currentCost - _target) < Math.abs(result - _target) || Math.abs(_currentCost - _target) < Math.abs(result - _target) && _currentCost == result) {
            result = _currentCost;
        }
        if (_index == _toppingCosts.length || _currentCost == _target) {
            return;
        }
        recursion(_currentCost, _toppingCosts, _index + 1, _target);
        recursion(_currentCost + _toppingCosts[_index], _toppingCosts, _index + 1, _target);
        recursion(_currentCost + _toppingCosts[_index] * 2, _toppingCosts, _index + 1, _target);
    }

}
