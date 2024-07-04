package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2285. Maximum Total Importance of Roads.
 */
class Problem2285 extends LeetcodeProblem {

    long maximumImportance(int _nbCities, int[][] _roads) {
        int[] deg = new int[_nbCities];
        for (int[] r : _roads) {
            deg[r[0]]++;
            deg[r[1]]++;
        }
        Arrays.sort(deg);
        long result = 0;
        for (int i = 0; i < _nbCities; i++) {
            result += (long) (i + 1) * deg[i];
        }
        return result;
    }

}
