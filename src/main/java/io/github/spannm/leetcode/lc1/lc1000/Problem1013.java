package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1013 extends LeetcodeProblem {

    boolean canThreePartsEqualSum(int[] _arr) {
        int sum = 0;
        for (int element : _arr) {
            sum += element;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int equalSum = sum / 3;
        int left = 0;
        int leftSum = 0;
        while (left < _arr.length - 2 && leftSum != equalSum) {
            leftSum += _arr[left++];
        }
        if (left > _arr.length - 2 || leftSum != equalSum) {
            return false;
        }

        int right = _arr.length - 1;
        int rightSum = 0;
        while (right > left && rightSum != equalSum) {
            rightSum += _arr[right--];
        }
        if (right < left || rightSum != equalSum) {
            return false;
        }
        int middleSum = 0;
        for (int i = left; i <= right; i++) {
            middleSum += _arr[i];
        }
        return middleSum == equalSum;
    }

}
