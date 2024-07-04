package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1891 extends LeetcodeProblem {

    int maxLength(int[] _ribbons, int _k) {
        long sum = 0L;
        int max = _ribbons[0];
        for (int num : _ribbons) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum < _k) {
            return 0;
        } else if (sum == _k) {
            return 1;
        } else {
            Arrays.sort(_ribbons);
            int left = 1;
            int right = max;
            int ans = 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = 0;
                for (int i = _ribbons.length - 1; i >= 0; i--) {
                    count += _ribbons[i] / mid;
                    if (count >= _k) {
                        ans = Math.max(ans, mid);
                        break;
                    }
                }
                if (count < _k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int count = 0;
            for (int i = _ribbons.length - 1; i >= 0; i--) {
                count += _ribbons[i] / left;
                if (count >= _k) {
                    ans = Math.max(ans, left);
                    return ans;
                }
            }
            return ans;
        }
    }

}
