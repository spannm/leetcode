package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1979 extends LeetcodeProblem {

    int findGCD(int[] _nums) {
        Arrays.sort(_nums);
        return getGcd(_nums[0], _nums[_nums.length - 1]);
    }

    int getGcd(int _a, int _b) {
        return _b == 0 ? _a : getGcd(_b, _a % _b);
    }

}
