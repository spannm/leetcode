package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1423 extends LeetcodeProblem {

    int maxScore(int[] _cardPoints, int _k) {
        int maxScore = 0;
        if (_cardPoints.length <= _k) {
            for (int point : _cardPoints) {
                maxScore += point;
            }
            return maxScore;
        }
        for (int i = 0; i < _k; i++) {
            maxScore += _cardPoints[i];
        }
        int runningSum = maxScore;
        for (int i = _cardPoints.length - 1, j = 1; i >= 0 && j <= _k; i--, j++) {
            runningSum = runningSum - _cardPoints[_k - j] + _cardPoints[i];
            maxScore = Math.max(maxScore, runningSum);
        }
        return maxScore;
    }

}
