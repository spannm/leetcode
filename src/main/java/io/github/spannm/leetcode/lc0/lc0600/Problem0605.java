package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/can-place-flowers/">605. Can Place Flowers</a>.
 */
class Problem0605 extends LeetcodeProblem {

    boolean canPlaceFlowers(int[] _flowerbed, int _n) {
        if (_n < 1) {
            return true;
        }

        final int len = _flowerbed.length;
        int nbFilled = 0;

        for (int i = 0; i < len; i++) {
            if (_flowerbed[i] == 0) {
                // empty spot. Can it be filled?
                boolean prevEmpty = i == 0 || _flowerbed[i - 1] == 0;
                boolean nextEmpty = i == len - 1 || _flowerbed[i + 1] == 0;
                if (prevEmpty && nextEmpty) {
                    _flowerbed[i] = 1;
                    nbFilled++;
                    if (nbFilled == _n) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

}
