package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0360 extends LeetcodeProblem {

    int[] sortTransformedArray(int[] _nums, int _a, int _b, int _c) {
        int len = _nums.length;
        int[] sorted = new int[len];
        int i = 0;
        int j = len - 1;
        int index = _a >= 0 ? len - 1 : 0;
        while (i <= j) {
            if (_a >= 0) {
                sorted[index--] =
                    mult(_nums[i], _a, _b, _c) >= mult(_nums[j], _a, _b, _c) ? mult(
                        _nums[i++], _a, _b, _c) : mult(_nums[j--], _a, _b, _c);
            } else {
                sorted[index++] =
                    mult(_nums[i], _a, _b, _c) >= mult(_nums[j], _a, _b, _c) ? mult(
                        _nums[j--], _a, _b, _c) : mult(_nums[i++], _a, _b, _c);
            }
        }
        return sorted;
    }

    static int mult(int _num, int _a, int _b, int _c) {
        return _a * _num * _num + _b * _num + _c;
    }

}
