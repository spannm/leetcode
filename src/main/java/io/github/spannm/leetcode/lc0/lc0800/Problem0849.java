package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0849 extends LeetcodeProblem {
    private int maxDist = 0;

    int maxDistToClosest(int[] _seats) {
        for (int i = 0; i < _seats.length; i++) {
            if (_seats[i] == 0) {
                extend(_seats, i);
            }
        }
        return maxDist;
    }

    private void extend(int[] _seats, int _position) {
        int left = _position - 1;
        int right = _position + 1;
        int leftMinDistance = 1;
        while (left >= 0) {
            if (_seats[left] == 0) {
                leftMinDistance++;
                left--;
            } else {
                break;
            }
        }
        int rightMinDistance = 1;
        while (right < _seats.length) {
            if (_seats[right] == 0) {
                rightMinDistance++;
                right++;
            } else {
                break;
            }
        }
        int maxReach = 0;
        if (_position == 0) {
            maxReach = rightMinDistance;
        } else if (_position == _seats.length - 1) {
            maxReach = leftMinDistance;
        } else {
            maxReach = Math.min(leftMinDistance, rightMinDistance);
        }
        maxDist = Math.max(maxDist, maxReach);
    }

}
