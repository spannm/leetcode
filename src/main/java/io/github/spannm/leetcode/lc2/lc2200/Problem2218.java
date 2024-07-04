package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/">2218. Maximum Value of K Coins From
 * Piles</a>.
 */
class Problem2218 extends LeetcodeProblem {

    int maxValueOfCoins(List<List<Integer>> _piles, int _nbCoins) {
        final int size = _piles.size();
        int beginPile = size - 1;
        return calc(_piles, beginPile, _nbCoins, new Integer[size + 1][_nbCoins + 1]);
    }

    static int calc(List<List<Integer>> _piles, int _currentPile, int _remainingCoins, Integer[][] _dp) {
        if (_currentPile < 0 || _remainingCoins == 0) {
            return 0;
        } else if (_dp[_currentPile][_remainingCoins] != null) {
            return _dp[_currentPile][_remainingCoins];
        }

        int coinsLimit = Math.min(_remainingCoins, _piles.get(_currentPile).size());

        int exclCurrPile = calc(_piles, _currentPile - 1, _remainingCoins, _dp);

        int inclCurrPile = 0;
        for (int idx = 0, sum = 0; idx < coinsLimit; idx++) {
            sum += _piles.get(_currentPile).get(idx);
            inclCurrPile = Math.max(sum + calc(_piles, _currentPile - 1, _remainingCoins - (idx + 1), _dp), inclCurrPile);
        }

        int result = Math.max(inclCurrPile, exclCurrPile);
        _dp[_currentPile][_remainingCoins] = result;

        return result;
    }

}
