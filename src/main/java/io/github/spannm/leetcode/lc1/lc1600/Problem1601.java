package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/">1601. Maximum Number of
 * Achievable Transfer Requests</a>.
 */
class Problem1601 extends LeetcodeProblem {

    static int maximumRequests(final int _nbBuildings, final int[][] _requests) {

        int max = 0;
        final int[] counts = new int[_nbBuildings];

        for (int mask = 0; mask < 1 << _requests.length; mask++) {

            // if the subset is smaller than the current candidate, no need to check
            int bitCount = Integer.bitCount(mask);
            if (bitCount <= max) {
                continue;
            }

            // find net number of requests for each building
            Arrays.fill(counts, 0);
            int pos = 0;
            for (int cur = mask; cur > 0; cur >>= 1, pos++) {
                if ((cur & 1) == 1) {
                    counts[_requests[pos][0]]++;
                    counts[_requests[pos][1]]--;
                }
            }

            // check whether each building has 0 net requests
            if (Arrays.stream(counts).filter(k -> k != 0).findFirst().isEmpty()) {
                max = bitCount;
            }

        }
        return max;
    }

}
