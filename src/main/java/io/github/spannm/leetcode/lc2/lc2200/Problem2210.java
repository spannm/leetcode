package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2210 extends LeetcodeProblem {

    int countHillValley(int[] _nums) {
        int ans = 0;
        for (int i = 1; i < _nums.length - 1; i++) {
            if (_nums[i] == _nums[i - 1]) {
                continue;
            } else if (_nums[i] > _nums[i - 1]) {
                int tmp = i;
                boolean moved = false;
                while (tmp + 1 < _nums.length && _nums[tmp] == _nums[tmp + 1]) {
                    moved = true;
                    tmp++;
                }
                if (moved) {
                    if (tmp + 1 < _nums.length && _nums[i] > _nums[tmp + 1]) {
                        ans++;
                    }
                } else {
                    if (_nums[i] > _nums[i + 1]) {
                        ans++;
                    }
                }
            } else if (_nums[i] < _nums[i - 1]) {
                int tmp = i;
                boolean moved = false;
                while (tmp + 1 < _nums.length && _nums[tmp] == _nums[tmp + 1]) {
                    moved = true;
                    tmp++;
                }
                if (moved) {
                    if (tmp + 1 < _nums.length && _nums[i] < _nums[tmp + 1]) {
                        ans++;
                    }
                } else {
                    if (_nums[i] < _nums[i + 1]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
