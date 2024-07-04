package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0410 extends LeetcodeProblem {

    int splitArray(int[] _nums, int _m) {
        int max = 0;
        long sum = 0;
        for (int num : _nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (_m == 1) {
            return (int) sum;
        }

        long l = max;
        long r = sum;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (isValid(mid, _nums, _m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    static boolean isValid(long _target, int[] _nums, int _m) {
        int count = 1;
        long total = 0;
        for (int num : _nums) {
            total += num;
            if (total > _target) {
                total = num;
                count++;
                if (count > _m) {
                    return false;
                }
            }
        }
        return true;
    }

}
