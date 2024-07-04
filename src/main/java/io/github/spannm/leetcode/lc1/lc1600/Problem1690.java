package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1690 extends LeetcodeProblem {

    private int[]         stonesRef;

    private int[]         prepareSums;

    private final int[][] maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ = new int[1005][1005];

    int stoneGameVII(int[] _stones) {
        stonesRef = _stones;
        int totalStonesNumber = _stones.length;
        prepareSums = new int[totalStonesNumber + 1];
        for (int i = 1; i <= totalStonesNumber; i++) {
            prepareSums[i] = prepareSums[i - 1] + _stones[i - 1];
        }
        for (int len = 1; len <= totalStonesNumber; len++) {
            for (int i = 1; i + len - 1 <= totalStonesNumber; i++) {
                int j = i + len - 1;
                setMaxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ(i, j);
            }
        }
        return maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[1][totalStonesNumber];
    }

    private void setMaxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ(int _i, int _j) {
        if (_j - _i == 0) {
            maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[_i][_j] = 0;
        } else if (_j - _i == 1) {
            maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[_i][_j] = Math.max(stonesRef[_i - 1], stonesRef[_j - 1]);
        } else {
            maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[_i][_j] = Math.max(
                sumOfTheStonesValueInPosIToJ(_i + 1, _j)
                    - maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[_i + 1][_j],
                sumOfTheStonesValueInPosIToJ(_i, _j - 1)
                    - maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[_i][_j - 1]);
        }
    }

    private int sumOfTheStonesValueInPosIToJ(int _i, int _j) {
        return prepareSums[_j] - prepareSums[_i - 1];
    }

}
