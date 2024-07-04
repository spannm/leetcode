package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1395. Count Number of Teams
 * <p>
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value. You have to form a team of 3
 * soldiers amongst them under the following rules: Choose 3 soldiers with index (i, j, k) with rating (rating[i],
 * rating[j], rating[k]). A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k])
 * where (0 <= i < j < k < n). Return the number of teams you can form given the conditions. (soldiers can be part of
 * multiple teams).
 * <p>
 * Example 1: Input: rating = [2,5,3,4,1] Output: 3 Explanation: We can form three teams given the conditions. (2,3,4),
 * (5,4,1), (5,3,1).
 * <p>
 * Example 2: Input: rating = [2,1,3] Output: 0 Explanation: We can't form any team given the conditions.
 * <p>
 * Example 3: Input: rating = [1,2,3,4] Output: 4
 * <p>
 * Constraints: n == rating.length 1 <= n <= 200 1 <= rating[i] <= 10^5
 */
class Problem1395 extends LeetcodeProblem {

    int numTeams(int[] _rating) {
        int count = 0;

        for (int i = 0; i < _rating.length - 2; i++) {
            for (int j = i + 1; j < _rating.length - 1; j++) {
                if (_rating[j] > _rating[i]) {
                    for (int k = j + 1; k < _rating.length; k++) {
                        if (_rating[k] > _rating[j]) {
                            count++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < _rating.length - 2; i++) {
            for (int j = i + 1; j < _rating.length - 1; j++) {
                if (_rating[j] < _rating[i]) {
                    for (int k = j + 1; k < _rating.length; k++) {
                        if (_rating[k] < _rating[j]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

}
