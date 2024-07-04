package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2600. K Items With the Maximum Sum.
 */
class Problem2600 extends LeetcodeProblem {

    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        }
        if (numZeros >= k - numOnes) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }

}
