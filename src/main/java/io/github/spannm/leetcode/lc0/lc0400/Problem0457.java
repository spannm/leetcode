package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0457 extends LeetcodeProblem {

    boolean circularArrayLoop(int[] _nums) {
        int len = _nums.length;
        if (len <= 1) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (_nums[i] == 0) {
                continue;
            }

            int j = i;
            int k = getIndex(i, _nums, len);
            while (_nums[k] * _nums[i] > 0 && _nums[getIndex(k, _nums, len)] * _nums[i] > 0) {
                if (j == k) {

                    if (j == getIndex(j, _nums, len)) {
                        break;
                    }
                    return true;
                }
                j = getIndex(j, _nums, len);
                k = getIndex(getIndex(k, _nums, len), _nums, len);
            }

            j = i;
            int val = _nums[i];
            while (_nums[j] * val > 0) {
                int next = getIndex(j, _nums, len);
                _nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    static int getIndex(int _i, int[] _nums, int _len) {
        return _i + _nums[_i] >= 0 ? (_i + _nums[_i]) % _len : _len + (_i + _nums[_i]) % _len;
    }

}
