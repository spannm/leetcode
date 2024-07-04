package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas/">875. Koko Eating Bananas</a>.
 */
class Problem0875 extends LeetcodeProblem {

    int minEatingSpeed(int[] _piles, int _h) {
        int nbPiles = _piles.length;
        if (nbPiles > _h) { // not possible
            return -1;
        }

        int minBananaPerHour = 1;
        int maxBananaPerHour = java.util.Arrays.stream(_piles).max().orElse(-1);

        while (minBananaPerHour < maxBananaPerHour) {
            int midBananaPerHour = minBananaPerHour + (maxBananaPerHour - minBananaPerHour) / 2;
            if (check(_piles, midBananaPerHour, _h)) {
                maxBananaPerHour = midBananaPerHour;
            } else {
                minBananaPerHour = midBananaPerHour + 1;
            }
        }

        return minBananaPerHour;
    }

    boolean check(int[] _piles, int _bananasPerHour, int _maxHours) {
        int hours = 0;
        for (int pile : _piles) {
            int time = pile / _bananasPerHour;
            hours += time;
            if (pile % _bananasPerHour != 0) {
                hours++;
            }
            if (hours > _maxHours) {
                return false;
            }
        }
        return true;
    }

}
