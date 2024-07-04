package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2455 extends LeetcodeProblem {

    int averageValue(int[] _nums) {
        long sum = 0L;
        int count = 0;
        for (int num : _nums) {
            if (num % 3 == 0 && num % 2 == 0) {
                sum += num;
                count++;
            }
        }
        return count != 0 ? (int) (sum / count) : 0;
    }

}
