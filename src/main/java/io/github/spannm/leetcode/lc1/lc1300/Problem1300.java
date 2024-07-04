package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1300 extends LeetcodeProblem {

    int findBestValue(int[] _arr, int _target) {
        int ave = _target / _arr.length;
        int max = _arr[0];
        int min = _arr[0];
        for (int i = 1; i < _arr.length; i++) {
            min = Math.min(min, _arr[i]);
            max = Math.max(max, _arr[i]);
        }
        if (ave >= max) {
            return max;
        }

        int closetDiff = findClosestDiffIfReplaceWithVal(_arr, ave, _target);
        int bestValue = ave;

        int candidateOnTheRight = ave;
        while (candidateOnTheRight <= max) {
            int thisOne = findClosestDiffIfReplaceWithVal(_arr, ++candidateOnTheRight, _target);
            if (thisOne >= closetDiff) {
                break;
            } else {
                closetDiff = thisOne;
                bestValue = candidateOnTheRight;
            }
        }

        int candidateOnTheLeft = ave;
        while (candidateOnTheLeft >= min) {
            int thisOne = findClosestDiffIfReplaceWithVal(_arr, --candidateOnTheLeft, _target);
            if (thisOne >= closetDiff) {
                break;
            } else {
                closetDiff = thisOne;
                bestValue = candidateOnTheLeft;
            }
        }
        return bestValue;
    }

    private int findClosestDiffIfReplaceWithVal(int[] _arr, int _replaceValue, int _target) {
        int sum = 0;
        for (int element : _arr) {
            sum += Math.min(element, _replaceValue);
        }
        return Math.abs(sum - _target);
    }

}
