package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/"> 1011. Capacity To Ship Packages
 * Within D Days</a>.
 */
class Problem1011 extends LeetcodeProblem {

    // Function to find the least weight capacity of a boat
    // to ship all the weights within _days days
    int shipWithinDays(final int[] _weights, final int _days) {
        final IntSummaryStatistics summaryStats = IntStream.of(_weights).summaryStatistics();
        final int nbWeights = (int) summaryStats.getCount();

        // Stores the total weights to be shipped
        final int totalWeightToShip = (int) summaryStats.getSum();

        // Stores the maximum weight in the array that has to be shipped
        int fromCapacity = summaryStats.getMax();

        // Stores the ending value for the search space
        int toCapacity = totalWeightToShip;

        int minReqCapacity = totalWeightToShip;

        // perform binary search
        while (fromCapacity <= toCapacity) {

            // Store the middle value
            final int candidateCapacity = fromCapacity + (toCapacity - fromCapacity) / 2;

            // Update search space, depending on whether candidate capacity can be shipped
            if (canShip(_weights, nbWeights, _days, candidateCapacity)) {
                minReqCapacity = candidateCapacity;
                // try next lower capacity
                toCapacity = candidateCapacity - 1;
            } else {
                // increase capacity
                fromCapacity = candidateCapacity + 1;
            }
        }

        return minReqCapacity;
    }

    /**
     * Function to check if the weights can be delivered in {@code _maxDays} days with daily capacity
     * {@code _dailyCapacity}.
     *
     * @param _weights array of weights
     * @param _nbWeights count of weights
     * @param _maxDays number of days available for shipping
     * @param _dailyCapacity daily capacity
     * @return true if possible, false otherwise
     */
    static boolean canShip(int[] _weights, int _nbWeights, int _maxDays, int _dailyCapacity) {
        // Stores the count of days required to ship all the weights
        // if the maximum capacity is _maxCapacity
        int elapsedDays = 1;
        int currWeight = 0;

        for (int idx = 0; idx < _nbWeights; idx++) {
            currWeight += _weights[idx];

            // move to next day, if aggregate weight exceeds daily capacity
            if (currWeight > _dailyCapacity) {
                elapsedDays++;
                currWeight = _weights[idx];
            }

            // if days are used up, return false
            if (elapsedDays > _maxDays) {
                return false;
            }
        }

        return true;
    }

}
