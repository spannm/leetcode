package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2256 extends LeetcodeProblem {

    int minimumAverageDifference(int[] _nums) {
        if (_nums.length == 1) {
            return 0;
        }
        long secondHalfSum = 0;
        int minAveDiff = Integer.MAX_VALUE;
        for (int i = 1; i < _nums.length; i++) {
            secondHalfSum += _nums[i];
        }
        long firstHalfSum = _nums[0];
        int count = 1;
        int minDiffIndex = 0;
        for (int i = 0; i < _nums.length;) {
            int firstHalfAve = (int) (firstHalfSum / count);
            int secondHalfAve = 0;
            if (_nums.length - count != 0) {
                secondHalfAve = (int) (secondHalfSum / (_nums.length - count));
            }
            if (minAveDiff > Math.abs(firstHalfAve - secondHalfAve)) {
                minAveDiff = Math.abs(firstHalfAve - secondHalfAve);
                minDiffIndex = i;
                if (minAveDiff == 0) {
                    return minDiffIndex;
                }
            }
            count++;
            i++;
            if (i < _nums.length) {
                firstHalfSum += _nums[i];
                secondHalfSum -= _nums[i];
            }
        }
        return minDiffIndex;
    }

}
