package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Street;

/**
 * 2753. Count Houses in a Circular Street II.
 */
class Problem2753 extends LeetcodeProblem {

    int houseCount(Street _street, int k) {
        while (!_street.isDoorOpen()) {
            _street.moveRight();
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            _street.moveRight();
            if (_street.isDoorOpen()) {
                ans = i;
                _street.closeDoor();
            }
        }
        return ans;
    }

}
