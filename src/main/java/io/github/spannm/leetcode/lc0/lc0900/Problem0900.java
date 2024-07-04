package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0900 extends LeetcodeProblem {

    static class RLEIterator {

        private int         index;
        private final int[] array;

        RLEIterator(int[] _arr) {
            index = 0;
            array = _arr;
        }

        int next(int _n) {
            int lastElement = -1;
            while (_n > 0 && index < array.length) {
                if (array[index] > _n) {
                    array[index] -= _n;
                    lastElement = array[index + 1];
                    break;
                } else if (array[index] == _n) {
                    array[index] = 0;
                    lastElement = array[index + 1];
                    index += 2;
                    break;
                } else {
                    _n -= array[index];
                    index += 2;
                }
            }
            return lastElement;
        }

    }

}
