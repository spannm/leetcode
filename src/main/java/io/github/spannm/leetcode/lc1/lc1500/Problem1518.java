package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1518 extends LeetcodeProblem {

    int numWaterBottles(int _numBottles, int _numExchange) {
        int drunk = _numBottles;
        int emptyBottles = _numBottles;
        while (emptyBottles >= _numExchange) {
            int exchangedBottles = emptyBottles / _numExchange;
            drunk += exchangedBottles;
            int unUsedEmptyBottles = emptyBottles % _numExchange;
            emptyBottles = exchangedBottles + unUsedEmptyBottles;
        }
        return drunk;
    }

}
