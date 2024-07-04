package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/">2147. Number of Ways to Divide a
 * Long Corridor</a>.
 */
class Problem2147 extends LeetcodeProblem {

    int numberOfWays(String _corridor) {
        int nbSeats = 0;
        int nbPlants = 0;
        long dividers = 1;

        for (char c : _corridor.toCharArray()) {
            if ('S' == c) {
                nbSeats++;
            } else if ('P' == c && nbSeats == 2) {
                nbPlants++;
            }

            if (nbSeats == 3) {
                dividers *= nbPlants + 1;
                dividers %= 1000000007;
                nbSeats = 1;
                nbPlants = 0;
            }
        }

        return nbSeats < 2 ? 0 : (int) dividers;
    }

}
