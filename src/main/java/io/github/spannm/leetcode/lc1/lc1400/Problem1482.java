package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1482. Minimum Number of Days to Make m Bouquets.
 */
class Problem1482 extends LeetcodeProblem {

    int minDays(int[] _bloomDays, int _nbBouquets, int _nbAdjFlowers) {
        int start = 0;
        int end = 0;
        for (int day : _bloomDays) {
            end = Math.max(end, day);
        }

        int minDays = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (countBouquets(_bloomDays, mid, _nbAdjFlowers) >= _nbBouquets) {
                minDays = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDays;
    }

    static int countBouquets(int[] _bloomDays, int _mid, int _nbAdjFlowers) {
        int nbBouquets = 0;
        int count = 0;

        for (int i = 0; i < _bloomDays.length; i++) {
            if (_bloomDays[i] <= _mid) {
                count++;
                if (count == _nbAdjFlowers) {
                    nbBouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }

        }

        return nbBouquets;
    }

}
