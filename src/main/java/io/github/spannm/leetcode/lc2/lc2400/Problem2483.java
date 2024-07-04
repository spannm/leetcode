package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-penalty-for-a-shop/">2483. Minimum Penalty for a Shop</a>.
 */
class Problem2483 extends LeetcodeProblem {

    int bestClosingTime(final String _customers) {
        final int nbCustomers = _customers.length();
        int[] yes = new int[nbCustomers + 1];
        int[] no = new int[nbCustomers + 1];

        int countY = 0;
        for (int i = nbCustomers - 1; i >= 0; i--) {
            if ('Y' == _customers.charAt(i)) {
                countY++;
            }
            yes[i] = countY;
        }

        int countN = 0;
        for (int i = 0; i < nbCustomers; i++) {
            if ('N' == _customers.charAt(i)) {
                countN++;
            }
            no[i + 1] = countN;
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < yes.length; i++) {
            int sum = yes[i] + no[i];
            if (min > sum) {
                min = sum;
                result = i;
            }

        }
        return result;
    }

}
