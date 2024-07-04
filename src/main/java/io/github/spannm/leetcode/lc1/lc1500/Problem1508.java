package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1508 extends LeetcodeProblem {

    int rangeSum(int[] _nums, int _n, int _left, int _right) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < _nums.length; i++) {
            long sum = _nums[i];
            list.add(sum);
            for (int j = i + 1; j < _nums.length; j++) {
                sum += _nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        long result = 0;
        for (int i = _left - 1; i < _right; i++) {
            result += list.get(i);
        }
        return (int) result % 1000000007;
    }

}
