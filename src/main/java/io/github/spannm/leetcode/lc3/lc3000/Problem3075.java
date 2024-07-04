package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 3075. Maximize Happiness of Selected Children.
 */
class Problem3075 extends LeetcodeProblem {

    long maximumHappinessSum(int[] _happ, int _k) {
        Arrays.sort(_happ);
        int len = _happ.length;
        return IntStream.range(0, _k).mapToLong(i -> _happ[len - i - 1] - i).filter(x -> x > 0).sum();
    }

}
