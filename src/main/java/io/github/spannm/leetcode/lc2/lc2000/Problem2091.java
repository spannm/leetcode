package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2091 extends LeetcodeProblem {

    int minimumDeletions(int[] _nums) {
        int minIdx = 0;
        int maxIdx = 0;
        int min = _nums[0];
        int max = _nums[0];
        for (int i = 1; i < _nums.length; i++) {
            if (_nums[i] > max) {
                max = _nums[i];
                maxIdx = i;
            }
            if (_nums[i] < min) {
                min = _nums[i];
                minIdx = i;
            }
        }
        int minDeletions = 0;
        if (_nums.length == 1) {
            return 1;
        }
        int len = _nums.length - 1;
        int firstIndex = Math.min(maxIdx, minIdx);
        int secondIndex = maxIdx == firstIndex ? minIdx : maxIdx;
        int firstDistance = firstIndex;
        int lastDistance = len - secondIndex;
        int betweenDistance = secondIndex - firstIndex;
        if (firstDistance < lastDistance) {
            minDeletions += firstDistance;
            minDeletions++;
            if (betweenDistance == 1 || lastDistance == 0) {
                minDeletions++;
                return minDeletions;
            } else if (betweenDistance <= lastDistance) {
                minDeletions += betweenDistance;
            } else {
                minDeletions += lastDistance;
                minDeletions++;
            }
        } else {
            minDeletions += lastDistance;
            minDeletions++;
            if (betweenDistance == 1 || firstDistance == 0) {
                minDeletions++;
                return minDeletions;
            } else if (betweenDistance <= firstDistance) {
                minDeletions += betweenDistance;
            } else {
                minDeletions += firstDistance;
                minDeletions++;
            }
        }
        return minDeletions;
    }

}
