package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1558 extends LeetcodeProblem {

    int minOperations(int[] _nums) {
        int ops = 0;
        while (!allZero(_nums)) {
            if (allEvenAndNonZeroes(_nums)) {
                _nums = half(_nums);
                ops++;
            } else if (hasOdds(_nums)) {
                int[] result = new int[_nums.length];
                for (int i = 0; i < _nums.length; i++) {
                    if (_nums[i] % 2 != 0) {
                        result[i] = _nums[i] - 1;
                        ops++;
                    } else {
                        result[i] = _nums[i];
                    }
                }
                _nums = result;
            } else {
                int[] result = new int[_nums.length];
                for (int i = 0; i < _nums.length; i++) {
                    if (_nums[i] != 0) {
                        result[i] = _nums[i] / 2;
                    } else {
                        result[i] = _nums[i];
                    }
                }
                _nums = result;
                ops++;
            }
        }
        return ops;
    }

    private boolean hasOdds(int[] _nums) {
        for (int i : _nums) {
            if (i % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    private int[] half(int[] _nums) {
        int[] result = new int[_nums.length];
        for (int i = 0; i < _nums.length; i++) {
            result[i] = _nums[i] / 2;
        }
        return result;
    }

    private boolean allEvenAndNonZeroes(int[] _nums) {
        for (int i : _nums) {
            if (i % 2 != 0 || i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean allZero(int[] _nums) {
        for (int i : _nums) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
