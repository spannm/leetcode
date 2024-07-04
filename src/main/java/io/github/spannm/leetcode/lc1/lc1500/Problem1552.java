package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1552. Magnetic Force Between Two Balls.
 */
class Problem1552 extends LeetcodeProblem {

    int maxDistance(int[] _basketPositions, int _nbBalls) {
        Arrays.sort(_basketPositions);
        int left = 1;
        int right = _basketPositions[_basketPositions.length - 1];
        while (left < right) {
            int mid = left + right + 1 >>> 1;
            if (check(_basketPositions, mid, _nbBalls)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    static boolean check(int[] _basketPositions, int _mid, int _nbBalls) {
        int prev = _basketPositions[0];
        int cnt = 1;
        for (int i = 1; i < _basketPositions.length; i++) {
            if (_basketPositions[i] - prev >= _mid) {
                prev = _basketPositions[i];
                cnt++;
            }
        }
        return cnt >= _nbBalls;
    }

}
