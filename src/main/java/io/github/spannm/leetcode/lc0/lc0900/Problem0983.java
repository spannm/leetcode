package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-for-tickets/">983. Minimum Cost For Tickets</a>.
 */
class Problem0983 extends LeetcodeProblem {

    int mincostTickets(int[] _days, int[] _ticketCosts) {
        final int travelDayCount = _days.length;
        final int firstTravelDay = _days[0];
        final int lastTravelDay = _days[travelDayCount - 1];

        int cost1 = _ticketCosts[0]; // 1-day ticket
        int cost7 = _ticketCosts[1]; // 7-day ticket
        int cost30 = _ticketCosts[2]; // 30-day ticket

        // array of travel costs: each entry represents the minimum cost to travel up to that day
        final int[] travelCosts = new int[lastTravelDay + 1];

        int lastDayIndex = 0;
        for (int dayOfYear = firstTravelDay; dayOfYear <= lastTravelDay; dayOfYear++) {
            int dayIndex = Arrays.binarySearch(_days, lastDayIndex, travelDayCount, dayOfYear);
            if (dayIndex > -1) { // a travel day
                lastDayIndex = dayIndex;
                travelCosts[dayOfYear] =
                    Math.min(travelCosts[dayOfYear - 1] + cost1,
                        Math.min(travelCosts[Math.max(0, dayOfYear - 7)] + cost7,
                            travelCosts[Math.max(0, dayOfYear - 30)] + cost30));
            } else {
                travelCosts[dayOfYear] = travelCosts[dayOfYear - 1];
            }
        }

        return travelCosts[lastTravelDay];
    }

}
